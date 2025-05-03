package school.sorokin.javacore.oop.onlineShop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Product prod1 = new Product(1L, "Airplane", "Toys", new BigDecimal("230"));
        Product prod2 = new Product(2L, "Illustrated Children's Book", "Children's products", new BigDecimal("30"));
        Product prod3 = new Product(3L, "Java Programming Guide", "Books", new BigDecimal("310"));
        Product prod4 = new Product(4L, "Plant", "Toys", new BigDecimal("120"));
        Product prod5 = new Product(5L, "Educational Building Blocks", "Children's products", new BigDecimal("30"));
        Product prod6 = new Product(6L, "Fantasy Novel Series", "Books", new BigDecimal("52"));
        Product prod7 = new Product(7L, "Construction Brick Set", "Toys", new BigDecimal("400"));
        Product prod8 = new Product(8L, "Software Development Principles", "Books", new BigDecimal("65"));
        Product prod9 = new Product(9L, "Educational pens", "Children's products", new BigDecimal("80"));

        Order o1 = new Order(101L, LocalDate.of(2021, 2, 10),
                LocalDate.of(2021, 2, 15), "Delivered",
                new HashSet<>(Arrays.asList(prod1, prod4)));
        Order o2 = new Order(102L, LocalDate.of(2021, 3, 14),
                LocalDate.of(2021, 3, 20), "Delivered",
                new HashSet<>(Arrays.asList(prod2, prod5, prod6)));
        Order o3 = new Order(103L, LocalDate.of(2021, 3, 15),
                LocalDate.of(2021, 3, 22), "Processing",
                new HashSet<>(Arrays.asList(prod3, prod7)));
        Order o4 = new Order(104L, LocalDate.of(2021, 3, 15),
                LocalDate.of(2021, 3, 25), "Delivered",
                new HashSet<>(Arrays.asList(prod8, prod9)));
        Order o5 = new Order(105L, LocalDate.of(2021, 2, 20),
                LocalDate.of(2021, 2, 28), "Delivered",
                new HashSet<>(Arrays.asList(prod1, prod2, prod3)));
        Order o6 = new Order(106L, LocalDate.of(2021, 3, 14),
                LocalDate.of(2021, 3, 19), "Delivered",
                new HashSet<>(Arrays.asList(prod4, prod5)));
        Order o7 = new Order(107L, LocalDate.of(2021, 3, 10),
                LocalDate.of(2021, 3, 15), "Delivered",
                new HashSet<>(Arrays.asList(prod6, prod7, prod8)));
        Order o8 = new Order(108L, LocalDate.of(2021, 2, 5),
                LocalDate.of(2021, 2, 10), "Delivered",
                new HashSet<>(List.of(prod9)));
        Order o9 = new Order(109L, LocalDate.of(2021, 3, 14),
                LocalDate.of(2021, 3, 18), "Processing",
                new HashSet<>(Arrays.asList(prod1, prod2, prod5)));
        Order o10 = new Order(110L, LocalDate.of(2021, 3, 15),
                LocalDate.of(2021, 3, 21), "Delivered",
                new HashSet<>(Arrays.asList(prod3, prod6, prod7)));

        Customer c1 = new Customer(1L, "Ashlie", 1L, new HashSet<>(Arrays.asList(o1, o2, o3, o4, o5)));
        Customer c2 = new Customer(2L, "Andrei", 2L, new HashSet<>(Arrays.asList(o6, o7, o8, o9, o10)));
        Customer c3 = new Customer(3L, "Charlie", 2L, new HashSet<>(Arrays.asList(o1, o3, o5, o7, o9)));
        Customer c4 = new Customer(4L, "John", 3L, new HashSet<>(Arrays.asList(o2, o4, o6, o8, o10)));
        Customer c5 = new Customer(5L, "Eva", 1L, new HashSet<>(Arrays.asList(o1, o2, o4, o7, o10)));
        Customer c6 = new Customer(5L, "Elfie", 1L, new HashSet<>(Arrays.asList(o3, o5, o7, o8, o9)));

        List<Customer> customers = List.of(c1, c2, c3, c4, c5, c6);

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
//        4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.

//        5. Получите топ 2 самые дешевые продукты из категории "Books".
//        6. Получите 3 самых последних сделанных заказа.
//        7. Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните
//        список их продуктов.
//        8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
//        9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.
//        10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех
//        продуктов категории "Книги".
//        11. Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе
//        12. Создайте Map<Customer, List<Order>> → key - покупатель, value - список его заказов
//        13. Создайте Map<Order, Double> → key - заказ, value - общая сумма продуктов заказа.
//        14. Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории
//        15. Получите Map<String, Product> → самый дорогой продукт по каждой категории.

    }
}
