package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLDAO;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("userDAO")
public class UserPostgreSQLDAO implements PostgreSQLDAO {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(Object object) {
        userRepository.save((User) object);
        return true;
    }
    @Override
    public int count(){
        return (int)userRepository.count();
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public Object readById(int id) {
        if (userRepository.existsById(id)) {
            return userRepository.getById(id);
        }
        return null;
    }

    @Override
    public boolean update(Object object, int id) {
        if (userRepository.existsById(id)) {
            User user = (User) object;
            user.setId(id);
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getByValue(String column, Integer value) {
        return null;
    }
}
