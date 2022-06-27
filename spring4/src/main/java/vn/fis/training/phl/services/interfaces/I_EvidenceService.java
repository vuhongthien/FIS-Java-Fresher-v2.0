package vn.fis.training.phl.services.interfaces;

import org.springframework.stereotype.Service;
import vn.fis.training.phl.models.CriminalCase;
import vn.fis.training.phl.models.Evidence;

import java.util.List;

@Service
public interface I_EvidenceService {
    List<Evidence> getAll();

    Evidence findById(Long idEvidence);

    Evidence create(Evidence createEvidence);

    Evidence update(Evidence updateEvidence);

    Evidence delete(Long id);
}
