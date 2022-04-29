package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component("commentDAO")
public class CommentPostgreSQL implements PostgreSQLCRUD<Comment>, PostgreSQLgetByValue<Comment> {


    private CommentRepository commentRepository;

    @Autowired
    public CommentPostgreSQL(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean create(Comment object) {
        commentRepository.save(object);
        return true;
    }

    @Override
    public int count() {
        return (int) commentRepository.count();
    }

    @Override
    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment readById(int id) {
        if (commentRepository.existsById(id)) {
            return commentRepository.findById(id).get();
        }
        return null;
    }


    @Override
    public boolean update(Comment object, int id) {
        if (commentRepository.existsById(id)) {
            object.setId(id);
            commentRepository.saveAndFlush(object);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> getByValue(String column, Integer value) {
        List<Comment> o = new ArrayList<Comment>();
        if (column.equals("author_id")) {
            o = commentRepository.getByAouthorId(value);
        } else {
            if (column.equals("post_id")) {
                o = commentRepository.getByPostId(value);
            }
        }
        return o;
    }
}
