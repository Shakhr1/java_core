package school.sorokin.javacore.oop.onlineShop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = createData();


// 1. Получите список продуктов из категории "Books" с ценой более 100.
        List<Product> prodOver100 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books") &&
                                   product.getPrice().compareTo(new BigDecimal("100")) > 0)
                .distinct()
                .toList();
        System.out.println("Задание 1: книга дороже 100");
        prodOver100.forEach(System.out::println);

// 2. Получите список заказов с продуктами из категории "Children's products".
        List<Order> listCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Children's products")))
                .distinct()
                .toList();
        System.out.println("\nЗадание 2: Children prod list");
        listCategory.forEach(System.out::println);

// 3. Получите список продуктов из категории "Toys" и примените скидку 10% и получите сумму всех продуктов.
        List<Product> discountedToys = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Toys"))
                .distinct()
                .map(product -> new Product(
                        product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice()
                                .multiply(new BigDecimal("0.9"))))
                .toList();
        BigDecimal totalToys = discountedToys.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nЗадание 3: toys with discount % 10");
        discountedToys.forEach(System.out::println);
        System.out.println("Общая сумма: " + totalToys);

// 4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.
        List<Product> prodSecondLevel = customers.stream()
                .filter(customer -> customer.getLevel() == 2)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)))
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
        System.out.println("\nЗадание 4: Продукты заказанные за февраль - март");
        prodSecondLevel.forEach(System.out::println);

// 5. Получите топ 2 самые дешевые продукты из категории "Books".
        List<Product> top2Books = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .toList();
        System.out.println("\nЗадание 5: Top 2 books");
        top2Books.forEach(System.out::println);

        // 6. Получите 3 самых последних сделанных заказа.
        List<Order> threeLatestOrders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toList();
        System.out.println("\nЗадание 6: 3 latest orders");
        threeLatestOrders.forEach(System.out::println);

        //7.Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните список их продуктов.
        System.out.println("\nЗадание 7: list products from march");

        List<Product> prodFromMarch = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021,3,15)))
                .peek(order -> System.out.println("ID: " + order.getId()))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
        prodFromMarch.forEach(System.out::println);
// 8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
        BigDecimal totalSumFebOrders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getYear() == 2021
                                 && order.getOrderDate().getMonthValue() == 2)
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nЗадание 8: Total sum feb 2021: " + totalSumFebOrders);

// 9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.
        List<BigDecimal> totalsForMar = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021,3,14)))
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .toList();
        double averageForMar = totalsForMar.stream()
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("\nЗадание 9: average pay for 14.03.2021: " + averageForMar);

//  10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех продуктов категории "Книги".
        DoubleSummaryStatistics statsBooks = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .summaryStatistics();
        System.out.println("\nЗадание 10: Stats for \"Books\":");
        System.out.println("Сумма: " + statsBooks.getSum());
        System.out.println("Среднее: " + statsBooks.getAverage());
        System.out.println("Максимум: " + statsBooks.getMax());
        System.out.println("Минимум: " + statsBooks.getMin());
        System.out.println("Количество: " + statsBooks.getCount());

// 11. Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе
        Map<Long, Integer> orderProdCounts = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));
        System.out.println("\nЗадание 11: Map: id -> count prod:");
        orderProdCounts.forEach((id, count) -> System.out.println("ID: " + id + " -> " + count));

// 12. Создайте Map<Customer, List<Order>> → key - покупатель, value - список его заказов
        Map<Customer, List<Order>> customerOrder = customers.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        customer -> new ArrayList<>(customer.getOrders())
                ));
        System.out.println("\nЗадание 12: Map: customer -> list orders:");
        customerOrder.forEach((customer, orders) -> {
            System.out.println(customer);
            orders.forEach(order -> System.out.println("   " + order));
        });
// 13. Создайте Map<Order, Double> → key - заказ, value - общая сумма продуктов заказа.
        Map<Order, Double> orderTotal = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .collect(Collectors.toMap(
                        order -> order,
                        order -> order.getProducts().stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                                .doubleValue()
                ));
        System.out.println("\nЗадание 13: Map: order -> total sum orders:");
        orderTotal.forEach((order, total) -> System.out.println("ID: " + order.getId() + " -> " + total));

// 14. Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории
        Map<String, List<String>> categoryProductName = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));
        System.out.println("\nЗадание 14: Map: category -> list order's names:");
        categoryProductName.forEach((category, names) ->
                System.out.println(category + " -> " + names)
        );

// 15. Получите Map<String, Product> → самый дорогой продукт по каждой категории.
        Map<String, Product> expensiveByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                opt -> opt.orElse(null)
                        )
                ));
        System.out.println("\nЗадание 15: Map: over price prod:");
        expensiveByCategory.forEach((category, product) ->
                System.out.println(category + " -> " + product)
        );
    }
    private static List<Customer> createData() {
        Product prod1 = new Product(1L, "Airplane", "Toys", new BigDecimal("230"));
        Product prod2 = new Product(2L, "Illustrated Children's Book", "Children's products", new BigDecimal("30"));
        Product prod3 = new Product(3L, "Java Programming Guide", "Books", new BigDecimal("310"));
        Product prod4 = new Product(4L, "Plant", "Toys", new BigDecimal("120"));
        Product prod5 = new Product(5L, "Educational Building Blocks", "Children's products", new BigDecimal("30"));
        Product prod6 = new Product(6L, "Fantasy Novel Series", "Books", new BigDecimal("52"));
        Product prod7 = new Product(7L, "Construction Brick Set", "Toys", new BigDecimal("400"));
        Product prod8 = new Product(8L, "Software Development Principles", "Books", new BigDecimal("65"));
        Product prod9 = new Product(9L, "Educational pens", "Children's products", new BigDecimal("80"));

        Order o1 = new Order(101L, LocalDate.of(2020, 2, 10),
                LocalDate.of(2021, 2, 15), "Delivered",
                new HashSet<>(Arrays.asList(prod1, prod4)));
        Order o2 = new Order(102L, LocalDate.of(2022, 3, 14),
                LocalDate.of(2021, 3, 20), "Delivered",
                new HashSet<>(Arrays.asList(prod2, prod5, prod6)));
        Order o3 = new Order(103L, LocalDate.of(2021, 4, 15),
                LocalDate.of(2021, 3, 22), "Processing",
                new HashSet<>(Arrays.asList(prod3, prod7)));
        Order o4 = new Order(104L, LocalDate.of(2021, 3, 1),
                LocalDate.of(2021, 3, 25), "Delivered",
                new HashSet<>(Arrays.asList(prod8, prod9)));
        Order o5 = new Order(105L, LocalDate.of(2021, 1, 20),
                LocalDate.of(2021, 2, 28), "Delivered",
                new HashSet<>(Arrays.asList(prod1, prod2, prod3)));
        Order o6 = new Order(106L, LocalDate.of(2021, 3, 15),
                LocalDate.of(2021, 3, 19), "Delivered",
                new HashSet<>(Arrays.asList(prod4, prod5)));
        Order o7 = new Order(107L, LocalDate.of(2021, 3, 10),
                LocalDate.of(2021, 3, 15), "Delivered",
                new HashSet<>(Arrays.asList(prod6, prod7, prod8)));
        Order o8 = new Order(108L, LocalDate.of(2021, 2, 5),
                LocalDate.of(2021, 2, 10), "Delivered",
                new HashSet<>(List.of(prod9)));
        Order o9 = new Order(109L, LocalDate.of(2021, 4, 14),
                LocalDate.of(2021, 3, 18), "Processing",
                new HashSet<>(Arrays.asList(prod1, prod2, prod5)));
        Order o10 = new Order(110L, LocalDate.of(2021, 3, 14),
                LocalDate.of(2021, 3, 21), "Delivered",
                new HashSet<>(Arrays.asList(prod3, prod6, prod7)));

        Customer c1 = new Customer(1L, "Ashlie", 1L, new HashSet<>(Arrays.asList(o1, o2, o3, o4, o5)));
        Customer c2 = new Customer(2L, "Andrei", 2L, new HashSet<>(Arrays.asList(o6, o7, o8, o9, o10)));
        Customer c3 = new Customer(3L, "Charlie", 2L, new HashSet<>(Arrays.asList(o1, o3, o5, o7, o9)));
        Customer c4 = new Customer(4L, "John", 3L, new HashSet<>(Arrays.asList(o2, o4, o6, o8, o10)));
        Customer c5 = new Customer(5L, "Eva", 1L, new HashSet<>(Arrays.asList(o1, o2, o4, o7, o10)));
        Customer c6 = new Customer(5L, "Elfie", 1L, new HashSet<>(Arrays.asList(o3, o5, o7, o8, o9)));

        return List.of(c1, c2, c3, c4, c5, c6);
    }
}
