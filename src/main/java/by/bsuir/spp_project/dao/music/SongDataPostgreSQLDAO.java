package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("songDataDAO")
@Service
public class SongDataPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private SongDataRepository repository;

    @Override
    public void create(Object object) {
        repository.save((SongData) object);
    }

    @Override
    public List readAll() {
        return repository.findAll();
    }

    @Override
    public Object readById(int id) {
        return repository.getOne(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (repository.existsById(id)) {
            SongData songdata = (SongData) object;
            songdata.setId(id);
            repository.save(songdata);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
}
