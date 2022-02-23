package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.H2DAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("songDataH2DAO")
public class SongDataH2DAO implements H2DAO {
    @Override
    public void create(Object object) {

    }

    @Override
    public List<Object> readAll() {
        return null;
    }

    @Override
    public Object readById(int id) {
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
