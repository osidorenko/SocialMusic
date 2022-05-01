package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.dao.files.PictureRepository;
import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("userDAO")
public class UserPostgreSQL implements PostgreSQLCRUD<User> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public boolean create(User object) {
        if (!pictureRepository.existsById(object.getPicture().getId()))
            pictureRepository.save(object.getPicture());
        else
            object.setPicture(pictureRepository.findById(object.getPicture().getId()).get());
        userRepository.save((User) object);

        return true;
    }

    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User readById(int id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(User object, int id) {
        if (userRepository.existsById(id)) {
            if (!pictureRepository.existsById(object.getPicture().getId()))
                pictureRepository.saveAndFlush(object.getPicture());
            else {
                User tmp = userRepository.findById(id).get();
                pictureRepository.updatePic(tmp.getPicture().getId(), object.getPicture().getName());
            }
            object.setId(id);
            User u = userRepository.save(object);
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
    public int getNext() {
        return 0;
    }
}
