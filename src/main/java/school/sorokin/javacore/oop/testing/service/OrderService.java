package school.sorokin.javacore.oop.testing.service;

import school.sorokin.javacore.oop.testing.exception.OrderNotFoundException;
import school.sorokin.javacore.oop.testing.model.Order;
import school.sorokin.javacore.oop.testing.repository.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order) {
        int result = orderRepository.saveOrder(order);
        return result > 0 ? "Order processed successfully"
                : "Order processing failed";
    }

    public double calculateTotal(int id) {
        Optional<Order> optional = orderRepository.getOrderById(id);
        return optional.map(Order::getTotalPrice).orElseThrow(()->
                new OrderNotFoundException(String.format("Order with id = %s not found", id)));
    }
}
