package dao.Interface;

import dao.StorageDAO;
import dao.TrackEntryDAO;

import java.util.List;

public interface ITrackEntryDAO {
    public void add(TrackEntryDAO trackEntryDAO);
    public TrackEntryDAO get(long id);
    public List<TrackEntryDAO> getAll();
    public TrackEntryDAO update(TrackEntryDAO trackEntryDAO);
    public TrackEntryDAO remove(long id);
}
