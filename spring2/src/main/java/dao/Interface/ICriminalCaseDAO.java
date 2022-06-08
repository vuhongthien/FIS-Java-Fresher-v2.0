package dao.Interface;

import entity.CriminalCase;
import entity.Detective;

import java.util.List;

public interface ICriminalCaseDAO {
    public CriminalCase get(long id);
    public List<CriminalCase> getAll();
    public void add(CriminalCase criminalCase);
    public CriminalCase remove(int code);
    public CriminalCase update(CriminalCase criminalCase);
}
