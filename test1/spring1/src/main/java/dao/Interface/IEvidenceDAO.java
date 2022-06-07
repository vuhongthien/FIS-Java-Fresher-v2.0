package dao.Interface;

import dao.EvidenceDAO;
import entity.Detective;

import java.util.List;

public interface IEvidenceDAO {
    public void add(EvidenceDAO evidenceDAO);
    public EvidenceDAO get(long id);
    public List<EvidenceDAO> getAll();
    public EvidenceDAO update(EvidenceDAO evidenceDAO);
    public EvidenceDAO remove(long id);
}
