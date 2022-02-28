package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.dao.music.SongDataRepository;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("commentDAO")
public class CommentPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private CommentRepository repository;

    @Override
    public void create(Object object) {
        repository.save((Comment) object);
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
            Comment com= (Comment) object;
            com.setId(id);
            repository.save(com);
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
