package by.bsuir.spp_project.dao.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("pictureDAO")
@Service
public class PicturePostgreSQL {

    @Autowired
    private PictureRepository pictureRepository;

}
