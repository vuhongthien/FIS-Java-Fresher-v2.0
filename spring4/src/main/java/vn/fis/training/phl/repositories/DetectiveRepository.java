package vn.fis.training.phl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.phl.models.Detective;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {
}
