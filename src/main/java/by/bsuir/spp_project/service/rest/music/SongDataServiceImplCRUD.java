package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.service.rest.RestServiceCRUD;
import by.bsuir.spp_project.service.rest.RestServiceGetByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SongDataServiceImplCRUD implements RestServiceCRUD<SongData>, RestServiceGetByValue<SongData> {

    private static final AtomicInteger SONG_DATA_ID_HOLDER = new AtomicInteger();

    private PostgreSQLCRUD<SongData> songdataDAO;

    private PostgreSQLgetByValue<SongData> postgreSQLgetByValue;

    @Autowired
    public SongDataServiceImplCRUD(@Qualifier("songDataDAO") PostgreSQLCRUD<SongData> songdataDAO, @Qualifier("songDataDAO") PostgreSQLgetByValue<SongData> postgreSQLgetByValue) {
        this.songdataDAO = songdataDAO;
        this.postgreSQLgetByValue = postgreSQLgetByValue;
    }

    @PostConstruct
    private void init() {
        SONG_DATA_ID_HOLDER.set(songdataDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }


    @Override
    public void create(SongData object) {
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
    public SongData readById(int id) {
        return songdataDAO.readById(id);
    }

    @Override
    public boolean update(SongData object, int id) {
        return songdataDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return songdataDAO.delete(id);
    }

    @Override
    public List<SongData> getByValue(String column, Integer value) {
        return postgreSQLgetByValue.getByValue(column, value);
    }
}
