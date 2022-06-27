package vn.fis.training.spring4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.spring4.models.Detective;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {
}
