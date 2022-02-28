package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;

import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostServiceImpl implements RestService {

    private static final Map<Integer, Post> POST_REP_MAP = new HashMap<>();
    private static final AtomicInteger POST_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("postDAO")
    private PostgreSQLDAO postDAO;

    private List<Object> posts;

    @PostConstruct
    private void init() {
        posts = postDAO.readAll();
        if (posts != null && !posts.isEmpty()) {
            Iterator iterator = posts.iterator();
            while (iterator.hasNext()) {
                Post post = (Post) iterator.next();
                POST_REP_MAP.put(post.getId(), post);
            }
            POST_ID_HOLDER.set(posts.size());
        }
    }

    @PreDestroy
    public void destroy() {
        int i = 0;
        if (posts != null) {
            i = posts.size();
        }
        ArrayList<Post> rep = new ArrayList<>(POST_REP_MAP.values());
        while (i < POST_ID_HOLDER.get()) {
            if (POST_REP_MAP.containsKey(i + 1)) {
                Post post = (Post) rep.get(i);
                post.setId(i + 1);
                postDAO.create(post);
            }
            i++;
        }
    }

    @Override
    public void create(Object object) {
        Post post = (Post) object;
        final int userId = POST_ID_HOLDER.incrementAndGet();
        post.setId(userId);
        POST_REP_MAP.put(userId, post);
    }

    @Override
    public List<Object> readAll() {
        return new ArrayList<>(POST_REP_MAP.values());
    }

    @Override
    public Object readById(int id) {
        return POST_REP_MAP.get(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (POST_REP_MAP.containsKey(id)) {
            Post post = (Post) object;
            post.setId(id);
            POST_REP_MAP.put(id, post);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return POST_REP_MAP.remove(id) != null;
    }
}
