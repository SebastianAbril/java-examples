package springbootmigrations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootmigrations.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
