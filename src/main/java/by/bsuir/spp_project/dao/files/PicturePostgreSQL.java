package by.bsuir.spp_project.dao.files;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.entity.files.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("pictureDAO")
@Service
public class PicturePostgreSQL implements PostgreSQLCRUD<Picture> {


    private PictureRepository pictureRepository;

    @Autowired
    public PicturePostgreSQL(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public int count() {
        return (int) pictureRepository.count();
    }

    @Override
    public boolean create(Picture object) {
        pictureRepository.save(object);
        return true;
    }

    @Override
    public List<Picture> readAll() {

        return pictureRepository.findAll();
    }

    @Override
    public Picture readById(int id) {
        return null;
    }

    @Override
    public boolean update(Picture object, int id) {
        if (pictureRepository.existsById(id)) {
            object.setId(id);
            pictureRepository.saveAndFlush(object);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public int getNext() {
        return 0;
    }
}
