package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;

import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.service.rest.RestServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostServiceCRUDImpl implements RestServiceCRUD<Post>, PostgreSQLgetByValue<Post> {

    private static final AtomicInteger POST_ID_HOLDER = new AtomicInteger();

    private PostgreSQLCRUD<Post> postDAO;

    private PostgreSQLgetByValue<Post> postgreSQLgetByValue;

    @Autowired
    public PostServiceCRUDImpl(@Qualifier("postDAO") PostgreSQLCRUD<Post> postDAO, @Qualifier("postDAO") PostgreSQLgetByValue<Post> postgreSQLgetByValue) {
        this.postDAO = postDAO;
        this.postgreSQLgetByValue = postgreSQLgetByValue;
    }

    @PostConstruct
    private void init() {
        POST_ID_HOLDER.set(postDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void create(Post object) {
        Post post = (Post) object;
        final int userId = POST_ID_HOLDER.incrementAndGet();
        post.setId(userId);
        postDAO.create(object);
    }

    @Override
    public List<Post> readAll() {
        return postDAO.readAll();
    }

    @Override
    public Post readById(int id) {
        return postDAO.readById(id);
    }

    @Override
    public boolean update(Post object, int id) {
        return postDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return postDAO.delete(id);
    }

    @Override
    public List<Post> getByValue(String column, Integer value) {
        return postgreSQLgetByValue.getByValue(column, value);
    }
}
