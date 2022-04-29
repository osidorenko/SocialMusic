package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.service.rest.RestServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service

public class SongServiceCRUDImpl implements RestServiceCRUD<Song> {

    private static final AtomicInteger SONG_ID_HOLDER = new AtomicInteger();


    private PostgreSQLCRUD<Song> songDAO;

    @Autowired
    public SongServiceCRUDImpl(@Qualifier("songDAO") PostgreSQLCRUD<Song> songDAO) {
        this.songDAO = songDAO;
    }

    @PostConstruct
    private void init() {
        SONG_ID_HOLDER.set(songDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }


    @Override
    public void create(Song object) {
        Song song = (Song) object;
        final int songId = SONG_ID_HOLDER.incrementAndGet();
        song.setId(songId);
        songDAO.create(song);
    }

    @Override
    public List<Song> readAll() {
        return songDAO.readAll();
    }

    @Override
    public Song readById(int id) {
        return songDAO.readById(id);
    }

    @Override
    public boolean update(Song object, int id) {
        return songDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return songDAO.delete(id);
    }

}
