package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.H2DAO;

import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommentServiceImpl implements RestService {

    private static final Map<Integer, Comment> COMMENT_REP_MAP = new HashMap<>();
    private static final AtomicInteger COMMENT_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("commentH2DAO")
    private H2DAO commentDAO;

    private List<Object> comments;

    @PostConstruct
    private void init() {
        comments = commentDAO.readAll();
        if (comments != null && !comments.isEmpty()) {
            Iterator iterator = comments.iterator();
            while (iterator.hasNext()) {
                Comment com = (Comment) iterator.next();
                COMMENT_REP_MAP.put(com.getId(), com);
            }
            COMMENT_ID_HOLDER.set(comments.size());
        }
    }

    @PreDestroy
    private void destroy() {
        int i = comments.size();
        while (i < COMMENT_ID_HOLDER.get()) {
            if (COMMENT_REP_MAP.containsKey(i)) {
                commentDAO.create(COMMENT_REP_MAP.get(i));
            }
            i++;
        }
    }


    @Override
    public void create(Object object) {
        Comment com = (Comment) object;
        final int userId = COMMENT_ID_HOLDER.incrementAndGet();
        com.setId(userId);
        COMMENT_REP_MAP.put(userId, com);
    }

    @Override
    public List<Object> readAll() {
        return new ArrayList<>(COMMENT_REP_MAP.values());
    }

    @Override
    public Object readById(int id) {
        return COMMENT_REP_MAP.get(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (COMMENT_REP_MAP.containsKey(id)) {
            Comment com = (Comment) object;
            com.setId(id);
            COMMENT_REP_MAP.put(id, com);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return COMMENT_REP_MAP.remove(id) != null;
    }
}
