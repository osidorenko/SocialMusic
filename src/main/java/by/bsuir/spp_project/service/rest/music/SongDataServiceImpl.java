package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.service.rest.RestService;
import ch.qos.logback.classic.net.SocketNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SongDataServiceImpl implements RestService {

    private static final AtomicInteger SONG_DATA_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("songDataDAO")
    private PostgreSQLDAO songdataDAO;


    @PostConstruct
    private void init() {
        SONG_DATA_ID_HOLDER.set(songdataDAO.count());

    }

    @PreDestroy
    public void destroy() {

    }


    @Override
    public void create(Object object) {
        SongData song = (SongData) object;
        final int songId = SONG_DATA_ID_HOLDER.incrementAndGet();
        song.setId(songId);
        songdataDAO.create(song);
    }

    @Override
    public List<SongData> readAll() {
        return songdataDAO.readAll();
    }

    @Override
    public Object readById(int id) {
        return songdataDAO.readById(id);
    }

    @Override
    public boolean update(Object object, int id) {
        return songdataDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return songdataDAO.delete(id);
    }

    @Override
    public List<SongData> getByValue(String column, Integer value) {
        return songdataDAO.getByValue(column, value);
    }
}
