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
    public void create(Object object) {
        Song song = (Song) object;

        songRepository.save(song);
    }

    @Override
    public List<Song> readAll() {
        return songRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        return songRepository.getOne(id);
    }

    @Override
    public boolean update(Object object, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        songRepository.deleteById(id);
        return true;
    }
}
