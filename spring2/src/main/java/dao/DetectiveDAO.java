package dao;

import dao.Interface.IDetectiveDAO;
import entity.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements IDetectiveDAO {
    private List<Detective> detectiveList = new ArrayList<>();
    @Override
    public void add(Detective detective) {

    }

    @Override
    public Detective get(long id) {
        Optional<Detective> opt = this.detectiveList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public Detective update(Detective detective) {
        detectiveList.add(Math.toIntExact(detective.getId()),detective);
        return detective;
    }

    @Override
    public Detective remove(long id) {
        for(Detective detective: this.detectiveList){
            if(detective.getId() == id) {
                this.detectiveList.remove(detective);
                return detective;
            }
        }
        return null;
    }
}
