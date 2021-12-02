package smartstake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smartstake.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
