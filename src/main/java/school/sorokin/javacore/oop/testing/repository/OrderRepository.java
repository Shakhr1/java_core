package school.sorokin.javacore.oop.testing.repository;

import school.sorokin.javacore.oop.testing.model.Order;

import java.util.Optional;

public interface OrderRepository {
    int saveOrder(Order order);
    Optional<Order> getOrderById (int id);
}
