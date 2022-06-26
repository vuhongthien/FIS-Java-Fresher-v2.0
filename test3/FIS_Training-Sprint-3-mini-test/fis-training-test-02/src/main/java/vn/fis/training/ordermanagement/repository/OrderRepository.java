package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.domain.OrderCart;

@Repository
public interface OrderRepository extends JpaRepository<OrderCart, Long> {
}
