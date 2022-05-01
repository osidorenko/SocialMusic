package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.dao.music.SongLikeRepository;
import by.bsuir.spp_project.entity.music.SongLike;
import by.bsuir.spp_project.entity.social.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongLikeController {

    private SongLikeRepository songLikeRepository;

    @Autowired
    public SongLikeController(SongLikeRepository songLikeRepository) {
        this.songLikeRepository = songLikeRepository;
    }

    @PostMapping(value = "/slikes/{song_id}/{user_id}/{like}")
    public ResponseEntity<?> create(@PathVariable("song_id") int song_id, @PathVariable("user_id") int user_id, @PathVariable("like") byte like) {
        /*Like likel = new Like(0, new User(user_id), new Post(song_id), like);
        likel.setId(LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3 + LocalTime.now().getMinute() + LocalTime.now().getSecond());
        likeRepository.save(likel);*/
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/slikes/{song_id}/{user_id}")
    public ResponseEntity<?> delete(@PathVariable("post_id") int post_id, @PathVariable("user_id") int user_id) {
        /*likeRepository.deleteLike(user_id, post_id);*/
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/slikes")
    public ResponseEntity<List<SongLike>> read() {
        List<SongLike> list = songLikeRepository.findAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
