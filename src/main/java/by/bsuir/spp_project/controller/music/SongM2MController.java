package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.dao.music.SongM2MRepository;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.entity.music.SongM2M;
import by.bsuir.spp_project.entity.social.Like;
import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class SongM2MController {
    private final SongM2MRepository songM2MRepository;

    @Autowired
    public SongM2MController(SongM2MRepository songM2MRepository) {
        this.songM2MRepository = songM2MRepository;
    }

    @PostMapping(value = "/app/songs/to/post/{post_id}/{song_id}")
    public ResponseEntity<?> create(@PathVariable("post_id") int post_id, @PathVariable("song_id") int song_id) {
        SongM2M songM2M = new SongM2M(0, new Post(post_id), new SongData(song_id));
        songM2M.setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3 + LocalTime.now().getNano() - song_id * 17) % Integer.MAX_VALUE);
        System.out.println("add song to post id" + songM2M.getId());
        songM2MRepository.save(songM2M);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/app/songs/to/post")
    public ResponseEntity<List<SongM2M>> read() {
        List<SongM2M> list = songM2MRepository.findAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
