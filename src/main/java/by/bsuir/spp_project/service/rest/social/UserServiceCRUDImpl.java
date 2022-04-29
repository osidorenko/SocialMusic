package by.bsuir.spp_project.service.rest.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.entity.social.User;
import by.bsuir.spp_project.service.rest.RestServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceCRUDImpl implements RestServiceCRUD<User> {


    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    private PostgreSQLCRUD<User> userDAO;

    @Autowired
    public UserServiceCRUDImpl(@Qualifier("userDAO") PostgreSQLCRUD<User> userDAO) {
        this.userDAO = userDAO;
    }

    @PostConstruct
    private void init() {
        USER_ID_HOLDER.set(userDAO.count());
    }

    @PreDestroy
    public void destroy() {

    }

    @Override
    public void create(User object) {
        final int userId = USER_ID_HOLDER.incrementAndGet();
        object.setId(userId);
        userDAO.create(object);
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
}
