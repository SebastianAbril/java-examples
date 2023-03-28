package springbootmigrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootmigrations.controller.dto.CreateOrderRequest;
import springbootmigrations.entity.Order;
import springbootmigrations.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody  CreateOrderRequest request) {
        Order order = orderService.createOrder(request.getCustomerId(), request.getProduct());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PostMapping("/order2")
    public Order createOrder2(@RequestBody  CreateOrderRequest request) {
        Order order = orderService.createOrder(request.getCustomerId(), request.getProduct());
        return order;
    }
}
