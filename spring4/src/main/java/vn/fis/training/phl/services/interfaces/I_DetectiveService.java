package vn.fis.training.phl.services.interfaces;

import org.springframework.stereotype.Service;
import vn.fis.training.phl.models.CriminalCase;
import vn.fis.training.phl.models.Detective;

import java.util.List;

@Service
public interface I_DetectiveService {
    List<Detective> getAll();

    Detective findById(Long idDetective);

    Detective create(Detective createDetective);

    Detective update(Detective updateDetective);

    Detective delete(Long id);
}
