package school.sorokin.javacore.oop.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.sorokin.javacore.oop.testing.model.Order;
import school.sorokin.javacore.oop.testing.repository.OrderRepository;
import school.sorokin.javacore.oop.testing.service.OrderService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private OrderRepository repository;
    private OrderService service;
    private Order order;

    @BeforeEach
    void init() {
        repository = mock(OrderRepository.class);
        service = new OrderService(repository);
        order = new Order(3, "MacBook",1, 1990.0);
    }

    @Test
    void processOrderSuccess() {
        when(repository.saveOrder(order)).thenReturn(1);

        String message = service.processOrder(order);

        assertEquals("Order processed successfully", message);
        verify(repository, times(1)).saveOrder(order);
    }

    @Test
    void processOrderFailure() {
        when(repository.saveOrder(order)).thenReturn(0);

        String message = service.processOrder(order);

        assertEquals("Order processing failed", message);
        verify(repository, times(1)).saveOrder(order);
    }

    @Test
    void processOrderThrowsException() {
        when(repository.saveOrder(order)).thenThrow(new RuntimeException("Something went wrong"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.processOrder(order));

        assertEquals("Something went wrong", exception.getMessage());
        verify(repository, times(1)).saveOrder(order);
    }

    @Test
    void calculateTotalSuccess() {
        when(repository.getOrderById(1)).thenReturn(Optional.of(order));

        double total = service.calculateTotal(1);

        assertEquals(1990.0, total, 0.0001);
        verify(repository, times(1)).getOrderById(1);
    }

    @Test
    void calculateTotalOrderNotFound() {
        when(repository.getOrderById(22)).thenReturn(Optional.empty());

        double total = service.calculateTotal(22);

        assertEquals(0.0, total, 0.0001);
        verify(repository, times(1)).getOrderById(22);
    }

    @Test
    void calculateTotalWithZeroQuantity() {
        order = new Order(5, "Airpods", 0, 25.0);
        when(repository.getOrderById(5)).thenReturn(Optional.of(order));

        double total = service.calculateTotal(5);

        assertEquals(0.0, total, 0.0001);
        verify(repository, times(1)).getOrderById(5);
    }

    @Test
    void calculateTotalWithZeroUnitPrice() {
        order = new Order(3, "Iphone", 3, 0.0);
        when(repository.getOrderById(3)).thenReturn(Optional.of(order));

        double total = service.calculateTotal(3);

        assertEquals(0.0, total, 0.0001);
        verify(repository, times(1)).getOrderById(3);
    }
}
