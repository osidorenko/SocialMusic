package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("songDAO")
@Service
public class SongPostgreSQLDAO implements PostgreSQLDAO {

    @Autowired
    private SongRepository songRepository;

    @Override
    public boolean create(Object object) {
        Song song = (Song) object;
        songRepository.save(song);
        return true;
    }

    @Override
    public List<Song> readAll() {
        return songRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        if (songRepository.existsById(id)) {
            return (Song)songRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        Song song = (Song) object;
        if (songRepository.existsById(id)) {
            song.setId(id);
            songRepository.saveAndFlush(song);
            return true;
        }
        return false;
    }
    @Override
    public int count(){
        return (int)songRepository.count();
    }
    @Override
    public boolean delete(int id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List getByValue(String column, Integer value) {

        return null;
    }
}
