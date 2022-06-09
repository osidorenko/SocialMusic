package by.bsuir.spp_project.controller.social;

import by.bsuir.spp_project.dao.social.LikeRepository;
import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.entity.social.Like;
import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
public class LikesController {

    private final LikeRepository likeRepository;

    @Autowired
    public LikesController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @PostMapping(value = "/app/likes/{post_id}/{user_id}/{like}")
    public ResponseEntity<?> create(@PathVariable("post_id") int post_id, @PathVariable("user_id") int user_id, @PathVariable("like") byte like) {
        Like likel = new Like(user_id, post_id, like);
        likeRepository.save(likel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/app/likes/{post_id}/{user_id}")
    public ResponseEntity<?> delete(@PathVariable("post_id") int post_id, @PathVariable("user_id") int user_id) {
        likeRepository.deleteLike(user_id, post_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*

    @GetMapping(value = "/app/likes")
    public ResponseEntity<List<Like>> read() {
        List<Like> list = likeRepository.findAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
*/


}
