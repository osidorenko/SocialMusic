package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("commentDAO")
public class CommentPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public boolean create(Object object) {
        commentRepository.save((Comment) object);
        return true;
    }
    @Override
    public int count(){
        return (int)commentRepository.count();
    }
    @Override
    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        if (commentRepository.existsById(id)) {
            return commentRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        if (commentRepository.existsById(id)) {
            Comment com = (Comment) object;
            com.setId(id);
            commentRepository.saveAndFlush(com);
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
    public List getByValue(String column, Integer value) {
        List o = new ArrayList();
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
