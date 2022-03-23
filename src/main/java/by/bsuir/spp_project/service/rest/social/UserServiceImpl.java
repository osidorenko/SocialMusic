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
public class UserServiceImpl implements RestService<User> {


    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("userDAO")
    private PostgreSQLDAO<User> userDAO;


    @PostConstruct
    private void init() {
        USER_ID_HOLDER.set(userDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void create(User object) {
        User user = (User) object;
        final int userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        userDAO.create(user);
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Override
    public User readById(int id) {
        return userDAO.readById(id);
    }

    @Override
    public boolean update(User object, int id) {
        return userDAO.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public List<User> getByValue(String column, Integer value) {
        return null;
    }
}
