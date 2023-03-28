package springbootmigrations.service;

import org.springframework.stereotype.Service;
import springbootmigrations.entity.Customer;
import springbootmigrations.entity.Order;
import springbootmigrations.repository.CustomerRepository;
import springbootmigrations.repository.OrderRepository;

@Service
public class OrderService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public OrderService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Long customerId, String product) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with id " + customerId+ " not found"));

        Order order = new Order(customer, product);

        return orderRepository.save(order);
    }

}
