package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.dao.files.PictureRepository;
import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Component("postDAO")
public class PostPostgreSQL implements PostgreSQLCRUD<Post>, PostgreSQLgetByValue<Post>, PostgreSQLPost {

    private PostRepository postRepository;
    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    public PostPostgreSQL(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private static int last = 0;

    @Override
    public boolean create(Post object) {
        object.setId(LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3 - 7);
        object.getPicture().setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + LocalTime.now().getHour() * 17);
        while (pictureRepository.existsById(object.getPicture().getId())) {
            object.getPicture().setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + 1);
            System.err.println("picture set ID songData");
        }
        Picture picture = pictureRepository.save(object.getPicture());
        object.setPicture(picture);
        Post post = postRepository.save(object);
        last = post.getId();
        ;
        return true;
    }

    @Override
    public int getLast() {
        return last;
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public Post readById(int id) {
        if (postRepository.existsById(id)) {
            return postRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public int count() {
        return (int) postRepository.count();
    }

    @Override
    public boolean update(Post object, int id) {
        if (postRepository.existsById(id)) {
            object.setId(id);
            postRepository.saveAndFlush(object);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int getNext() {
        return 0;
    }

    @Override
    public List<Object> getPostsByUser(Integer user_id) {
        List<Object> list = postRepository.getPostsByUser(user_id);
        return list;
    }

    @Override
    public List<Post> getByValue(String column, Integer value) {
        List<Post> list = new ArrayList();
        if (column.equals("author_id")) {
            list = postRepository.getByAuthorId(value);
        }
        return list;
    }
}
