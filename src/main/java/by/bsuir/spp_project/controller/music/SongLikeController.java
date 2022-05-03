package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.dao.music.SongLikeRepository;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.entity.music.SongLike;
import by.bsuir.spp_project.entity.social.Like;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
public class SongLikeController {

    private SongLikeRepository songLikeRepository;

    @Autowired
    public SongLikeController(SongLikeRepository songLikeRepository) {
        this.songLikeRepository = songLikeRepository;
    }

    @PostMapping(value = "/app/likes/song/add/{song_id}/{user_id}")
    public ResponseEntity<?> create(@PathVariable("song_id") int song_id, @PathVariable("user_id") int user_id) {
        SongLike songLike = new SongLike(0, new User(user_id), new SongData(song_id));
        songLike.setId(LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3 + LocalTime.now().getMinute() + LocalTime.now().getSecond());
        songLikeRepository.save(songLike);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/app/likes/song/del/{song_id}/{user_id}")
    public ResponseEntity<?> delete(@PathVariable("song_id") int song_id, @PathVariable("user_id") int user_id) {
        songLikeRepository.deleteLike(user_id, song_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/app/likes/song")
    public ResponseEntity<List<SongLike>> read() {
        List<SongLike> list = songLikeRepository.findAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/likes/song/to/author/{user_id}")
    public ResponseEntity<List<SongLike>> readForUser(@PathVariable("user_id") int user_id) {
        List<SongLike> list = songLikeRepository.getAllByUser(user_id);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
