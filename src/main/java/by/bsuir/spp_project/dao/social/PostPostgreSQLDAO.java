package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("postDAO")
public class PostPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void create(Object object) {
        postRepository.save((Post) object);
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        if (postRepository.existsById(id)) {
            return postRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        if (postRepository.existsById(id)) {
            Post post = (Post) object;
            post.setId(id);
            postRepository.saveAndFlush(post);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List getByValue(String column, Integer value) {
        List list = new ArrayList();
        if (column.equals("author_id")) {
            list = postRepository.getByAuthorId(value);
        }
        return list;
    }
}
