package vn.fis.training.phl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.phl.models.CriminalCase;
import vn.fis.training.phl.models.Evidence;
import vn.fis.training.phl.repositories.CriminalCaseRepository;
import vn.fis.training.phl.repositories.EvidenceRepository;
import vn.fis.training.phl.services.interfaces.I_EvidenceService;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceServiceImpl implements I_EvidenceService {
    @Autowired
    private EvidenceRepository evidenceRepository ;

    @Override
    public List<Evidence> getAll() {
        return evidenceRepository.findAll();
    }

    @Override
    public Evidence findById(Long idEvidence) {
        Optional<Evidence> opt = evidenceRepository.findById(idEvidence);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @Override
    public Evidence create(Evidence createEvidence) {
        evidenceRepository.save(createEvidence);
        return findById(createEvidence.getId());
    }

    @Override
    public Evidence update(Evidence updateEvidence) {
        if(findById(updateEvidence.getId()) == null){
            return null;
        }
        evidenceRepository.save(updateEvidence);
        return findById(updateEvidence.getId());
    }

    @Override
    public Evidence delete(Long id) {
        Evidence findEvi = findById(id);
        if(findEvi == null){
            return null;
        }
        evidenceRepository.delete(findEvi);
        return new Evidence();
    }
}
