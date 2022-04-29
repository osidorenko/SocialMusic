package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;

import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.service.rest.RestServiceCRUD;
import by.bsuir.spp_project.service.rest.RestServiceGetByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommentServiceCRUDImpl implements RestServiceCRUD<Comment>, RestServiceGetByValue<Comment> {

    private static final AtomicInteger COMMENT_ID_HOLDER = new AtomicInteger();

    private PostgreSQLCRUD<Comment> commentDAO;

    private PostgreSQLgetByValue<Comment> postgreSQLgetByValue;

    @Autowired
    public CommentServiceCRUDImpl(@Qualifier("commentDAO") PostgreSQLCRUD<Comment> commentDAO, @Qualifier("commentDAO") PostgreSQLgetByValue<Comment> postgreSQLgetByValue) {
        this.commentDAO = commentDAO;
        this.postgreSQLgetByValue = postgreSQLgetByValue;
    }

    @PostConstruct
    private void init() {
        COMMENT_ID_HOLDER.set(commentDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void create(Comment object) {
        final int userId = COMMENT_ID_HOLDER.incrementAndGet();
        object.setId(userId);
        commentDAO.create(object);
    }

    @Override
    public List<Comment> readAll() {
        return commentDAO.readAll();
    }

    @Override
    public Comment readById(int id) {
        return commentDAO.readById(id);
    }

    @Override
    public boolean update(Comment object, int id) {
        return commentDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return commentDAO.delete(id);
    }

    @Override
    public List<Comment> getByValue(String column, Integer value) {
        return postgreSQLgetByValue.getByValue(column, value);
    }
}
