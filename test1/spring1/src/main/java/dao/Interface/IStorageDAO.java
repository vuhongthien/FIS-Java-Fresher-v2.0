package dao.Interface;

import dao.EvidenceDAO;
import dao.StorageDAO;

import java.util.List;

public interface IStorageDAO {
    public void add(StorageDAO storageDAO);
    public StorageDAO get(long id);
    public List<StorageDAO> getAll();
    public StorageDAO update(StorageDAO storageDAO);
    public StorageDAO remove(long id);
}
