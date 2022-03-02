package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component("songDataDAO")
@Service
public class SongDataPostgreSQLDAO implements PostgreSQLDAO {

    @Autowired
    private SongDataRepository songDataRepository;

    @Override
    public void create(Object object) {
        SongData songData = (SongData) object;
        List list = songDataRepository.getBySongId(songData.getSongId());
        if (list.isEmpty()){
            songDataRepository.save((SongData) object);
        }
    }

    @Override
    public List<SongData> readAll() {
        return songDataRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        if (songDataRepository.existsById(id)) {
            return songDataRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        if (songDataRepository.existsById(id)) {
            SongData songdata = (SongData) object;
            songdata.setId(id);
            songDataRepository.saveAndFlush(songdata);
            return true;
        }
        return false;
    }

    @Override
    public List<SongData> getByValue(String column, Integer value) {
        List o = new ArrayList();
        if (column.equals("song_id")) {
            o = songDataRepository.getBySongId(value);
        } else {
            if (column.equals("author_id")) {
                o = songDataRepository.getByAuthorId(value);
            }
        }
        return o;
    }

    @Override
    public boolean delete(int id) {
        if (songDataRepository.existsById(id)) {
            songDataRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
