package vn.fis.training.phl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.phl.models.Evidence;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
}
