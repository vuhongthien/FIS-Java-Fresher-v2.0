package dao.Interface;

import entity.Detective;

import java.util.List;

public interface IDetectiveDAO {
    public void add(Detective detective);
    public Detective get(long id);
    public List<Detective> getAll();
    public Detective update(Detective detective);
    public Detective remove(long id);
}
