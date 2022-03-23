package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;

import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommentServiceImpl implements RestService<Comment> {

    private static final AtomicInteger COMMENT_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("commentDAO")
    private PostgreSQLDAO<Comment> commentDAO;


    @PostConstruct
    private void init() {
        COMMENT_ID_HOLDER.set(commentDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void create(Comment object) {
        Comment com = (Comment) object;
        final int userId = COMMENT_ID_HOLDER.incrementAndGet();
        com.setId(userId);
        commentDAO.create(com);
    }

    @Override
    public List<Comment> readAll() {
        return commentDAO.readAll();
    }

    @Override
    public Comment readById(int id) {
        return readById(id);
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
        return commentDAO.getByValue(column, value);
    }
}
