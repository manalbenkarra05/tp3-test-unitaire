package Partie01;

import org.example.Partie01.Order;
import org.example.Partie01.OrderController;
import org.example.Partie01.OrderDao;
import org.example.Partie01.OrderService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.example.*;
public class OrderControllerTest {

    @Test
    public void testCreateOrder_CallsServiceAndDao() {
        // Arrange
        OrderDao mockDao = mock(OrderDao.class);
        OrderService orderService = new OrderService(mockDao);
        OrderController orderController = new OrderController(orderService);
        Order order = new Order("123", "Test order");

        // Act
        orderController.createOrder(order);

        // Assert
        verify(mockDao).saveOrder(order); // Vérifie que saveOrder a été appelé avec le bon objet
    }
}
