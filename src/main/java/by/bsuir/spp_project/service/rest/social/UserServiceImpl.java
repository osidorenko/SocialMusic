package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.social.User;
import by.bsuir.spp_project.service.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements RestService {

    private static final Map<Integer, User> USER_REP_MAP = new HashMap<>();
    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("userDAO")
    private PostgreSQLDAO userDAO;

    private List<Object> users;

    @PostConstruct
    private void init() {
        users = userDAO.readAll();
        if (users != null && !users.isEmpty()) {
            Iterator iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = (User) iterator.next();
                USER_REP_MAP.put(user.getId(), user);
            }
            USER_ID_HOLDER.set(users.size());
        }
    }

    @PreDestroy
    public void destroy() {
        int i = 0;
        if (users != null) {
            i = users.size();
        }
        ArrayList<User> rep = new ArrayList<>(USER_REP_MAP.values());
        while (i < USER_ID_HOLDER.get()) {
            if (USER_REP_MAP.containsKey(i + 1)) {
                User user = (User) rep.get(i);
                user.setId(i + 1);
                userDAO.create(user);
            }
            i++;
        }
    }

    @Override
    public void create(Object object) {
        User user = (User) object;
        final int userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        USER_REP_MAP.put(userId, user);
    }

    @Override
    public List<Object> readAll() {
        return new ArrayList<>(USER_REP_MAP.values());
    }

    @Override
    public Object readById(int id) {
        return USER_REP_MAP.get(id);
    }

    @Override
    public boolean update(Object object, int id) {
        if (USER_REP_MAP.containsKey(id)) {
            User user = (User) object;
            user.setId(id);
            USER_REP_MAP.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return USER_REP_MAP.remove(id) != null;
    }
}
