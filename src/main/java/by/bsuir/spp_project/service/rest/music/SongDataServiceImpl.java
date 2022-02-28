package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SongDataServiceImpl implements RestService {
    private static final Map<Integer, SongData> SONG_DATA_REP_MAP = new HashMap<>();
    private static final AtomicInteger SONG_DATA_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("songDataDAO")
    private PostgreSQLDAO songdataDAO;

    private List<Object> songsdata;

    /*
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
        public void destroy() {
            int i = 0;
            if (songs != null) {
                i = songs.size();
            }
            ArrayList<Song> rep = new ArrayList<>(SONG_REP_MAP.values());
            while (i < SONG_ID_HOLDER.get()) {
                if (SONG_REP_MAP.containsKey(i + 1)) {
                    Song song = (Song) rep.get(i);
                    song.setId(i + 1);
                    songDAO.create(song);
                }
                i++;
            }
        }
    */
    @PostConstruct
    private void init() {
        songsdata = songdataDAO.readAll();
        if (songsdata != null && !songsdata.isEmpty()) {
            Iterator iterator = songsdata.iterator();
            while (iterator.hasNext()) {
                SongData song = (SongData) iterator.next();
                SONG_DATA_REP_MAP.put(song.getId(), song);
            }
            SONG_DATA_ID_HOLDER.set(songsdata.size());
        }
    }

    @PreDestroy
    public void destroy() {
        int i = 0;
        if (songsdata != null) {
            i = songsdata.size();
        }
        ArrayList<SongData> rep = new ArrayList<>(SONG_DATA_REP_MAP.values());
        while (i < SONG_DATA_ID_HOLDER.get()) {
            if (SONG_DATA_REP_MAP.containsKey(i + 1)) {
                SongData song = (SongData) rep.get(i);
                song.setId(i + 1);
                songdataDAO.create(song);
            }
            i++;
        }
    }


    @Override
    public void create(Object object) {
        SongData song = (SongData) object;
        final int songId = SONG_DATA_ID_HOLDER.incrementAndGet();
        song.setId(songId);
        SONG_DATA_REP_MAP.put(songId, song);
    }

    @Override
    public List<Object> readAll() {
        return new ArrayList<>(SONG_DATA_REP_MAP.values());
    }

    @Override
    public Object readById(int id) {
        return SONG_DATA_REP_MAP.get(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (SONG_DATA_REP_MAP.containsKey(id)) {
            SongData song = (SongData) object;
            song.setId(id);
            SONG_DATA_REP_MAP.put(id, song);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return SONG_DATA_REP_MAP.remove(id) != null;
    }
}
