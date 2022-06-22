package repo;

import model.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoOrderCart extends JpaRepository<OrderCart, Long> {
}
