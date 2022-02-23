package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.H2DAO;
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
    //todo trace exception for equals of types???

    private static final Map<Integer, Song> SONG_REP_MAP = new HashMap<>();
    private static final AtomicInteger SONG_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("songH2DAO")
    private H2DAO songDAO;

    private List<Object> songs;

    @PostConstruct
    private void init() {
        songs = songDAO.readAll();
        if (songs != null && !songs.isEmpty()) {
            Iterator iterator = songs.iterator();
            while (iterator.hasNext()) {
                Song song = (Song) iterator.next();
                SONG_REP_MAP.put(song.getId(), song);
            }
            SONG_ID_HOLDER.set(songs.size());
        }
    }

    @PreDestroy
    private void destroy() {
        int i = songs.size();
        while (i < SONG_ID_HOLDER.get()) {

            if (SONG_REP_MAP.containsKey(i)) {
                songDAO.create(SONG_REP_MAP.get(i));
            }
            i++;
        }
    }

/*
    @Autowired
    public SongServiceImpl(@Qualifier("songH2DAO") H2DAO songDAO) {
        songs = songDAO.readAll();
        int i = 0;
        Iterator iterator = songs.iterator();
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            SONG_REP_MAP.put(song.getId(), song);
        }
        SONG_ID_HOLDER.set(songs.size());
        this.songDAO = songDAO;
    }
*/

    @Override
    public void create(Object object) {
        Song song = (Song) object;
        final int songId = SONG_ID_HOLDER.incrementAndGet();
        song.setId(songId);
        SONG_REP_MAP.put(songId, song);
    }

    @Override
    public List<Object> readAll() {
        return new ArrayList<>(SONG_REP_MAP.values());
    }

    @Override
    public Object readById(int id) {
        return SONG_REP_MAP.get(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (SONG_REP_MAP.containsKey(id)) {
            Song song = (Song) object;
            song.setId(id);
            SONG_REP_MAP.put(id, song);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return SONG_REP_MAP.remove(id) != null;
    }
}