package vn.fis.training.spring4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.fis.training.spring4.models.CriminalCase;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {
    @Query("SELECT u FROM CriminalCase u")
    List<CriminalCase> getAll();

    @Query("SELECT u FROM CriminalCase u where u.id =:idCriminalCase")
    Optional<CriminalCase> findCriById(@Param("idCriminalCase") Long idCriminalCase);
}
