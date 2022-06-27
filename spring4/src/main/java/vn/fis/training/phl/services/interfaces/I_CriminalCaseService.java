package vn.fis.training.phl.services.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.fis.training.phl.models.CriminalCase;

import java.util.List;

@Service
public interface I_CriminalCaseService {
    List<CriminalCase> getAll();

    CriminalCase findById(Long idCriminalCase);

    CriminalCase create(CriminalCase createCriminal);

    CriminalCase update(CriminalCase updateCriminal);

    CriminalCase delete(Long id);
}
