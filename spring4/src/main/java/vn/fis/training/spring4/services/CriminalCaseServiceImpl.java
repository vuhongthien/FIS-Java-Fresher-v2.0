package vn.fis.training.spring4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.spring4.models.CriminalCase;
import vn.fis.training.spring4.repositories.CriminalCaseRepository;
import vn.fis.training.spring4.services.interfaces.I_CriminalCaseService;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl  implements I_CriminalCaseService {

    @Autowired
    private CriminalCaseRepository criminalCaseRepository ;

    @Override
    public List<CriminalCase> getAll() {
        return criminalCaseRepository.getAll();
    }

    @Override
    public CriminalCase findById(Long idCriminalCase) {
        Optional<CriminalCase> opt = criminalCaseRepository.findCriById(idCriminalCase);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @Override
    public CriminalCase create(CriminalCase createCriminal) {
        criminalCaseRepository.save(createCriminal);
        return findById(createCriminal.getId());
    }

    @Override
    public CriminalCase update(CriminalCase updateCriminal) {
        if(findById(updateCriminal.getId()) == null){
            return null;
        }
        criminalCaseRepository.save(updateCriminal);
        return findById(updateCriminal.getId());
    }

    @Override
    public CriminalCase delete(Long id) {
        CriminalCase findCri = findById(id);
        if(findCri == null){
            return null;
        }
        criminalCaseRepository.delete(findCri);
        return new CriminalCase();
    }
}
