package vn.fis.training.spring4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.spring4.models.Detective;
import vn.fis.training.spring4.repositories.DetectiveRepository;
import vn.fis.training.spring4.services.interfaces.I_DetectiveService;

import java.util.List;
import java.util.Optional;

@Service
public class DetectiveServiceImpl implements I_DetectiveService {

    @Autowired
    private DetectiveRepository detectiveRepository ;

    @Override
    public List<Detective> getAll() {
        return detectiveRepository.findAll();
    }

    @Override
    public Detective findById(Long idDetective) {
        Optional<Detective> opt = detectiveRepository.findById(idDetective);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @Override
    public Detective create(Detective createDetective) {
        detectiveRepository.save(createDetective);
        return findById(createDetective.getId());
    }

    @Override
    public Detective update(Detective updateDetective) {
        if(findById(updateDetective.getId()) == null){
            return null;
        }
        detectiveRepository.save(updateDetective);
        return findById(updateDetective.getId());
    }

    @Override
    public Detective delete(Long id) {
        Detective findDet = findById(id);
        if(findDet == null){
            return null;
        }
        detectiveRepository.delete(findDet);
        return new Detective();
    }
}
