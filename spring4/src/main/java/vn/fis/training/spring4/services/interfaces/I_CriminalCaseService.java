package vn.fis.training.spring4.services.interfaces;

import org.springframework.stereotype.Service;
import vn.fis.training.spring4.models.CriminalCase;

import java.util.List;

@Service
public interface I_CriminalCaseService {
    List<CriminalCase> getAll();

    CriminalCase findById(Long idCriminalCase);

    CriminalCase create(CriminalCase createCriminal);

    CriminalCase update(CriminalCase updateCriminal);

    CriminalCase delete(Long id);
}
