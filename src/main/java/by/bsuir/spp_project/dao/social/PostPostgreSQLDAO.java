package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("postDAO")
public class PostPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private PostRepository repository;

    @Override
    public void create(Object object) {
        repository.save((Post) object);
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
            Post post = (Post) object;
            post.setId(id);
            repository.save(post);
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
