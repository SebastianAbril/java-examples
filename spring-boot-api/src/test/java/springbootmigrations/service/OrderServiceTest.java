package springbootmigrations.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springbootmigrations.entity.Customer;
import springbootmigrations.entity.Order;
import springbootmigrations.repository.CustomerRepository;
import springbootmigrations.repository.OrderRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setName("Jhon");

        when(customerRepository.findById(1l)).thenReturn(Optional.of(customer));

        orderService.createOrder(1l, "Product A");

        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testCustomerNotFound() {
        when(customerRepository.findById(1l)).thenReturn(Optional.empty());

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(1l, "Product A");
        });

        Assertions.assertEquals("Customer with id 1 not found", thrown.getMessage());
    }
}