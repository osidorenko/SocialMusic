package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service

public class SongServiceImpl implements RestService {

    private static final AtomicInteger SONG_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("songDAO")
    private PostgreSQLDAO songDAO;


    @PostConstruct
    private void init() {

    }

    @PreDestroy
    public void destroy() {

    }


    @Override
    public void create(Object object) {
        Song song = (Song) object;
        final int songId = SONG_ID_HOLDER.incrementAndGet();
        song.setId(songId);
        songDAO.create(song);
    }

    @Override
    public List<Object> readAll() {
        return songDAO.readAll();
    }

    @Override
    public Object readById(int id) {
        return songDAO.readById(id);
    }

    @Override
    public boolean update(Object object, int id) {
        return songDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return songDAO.delete(id);
    }
    @Override
    public List<Song> getByValue(String column, Integer value) {
        return null;
    }
}
