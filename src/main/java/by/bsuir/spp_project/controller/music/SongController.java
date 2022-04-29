package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.service.rest.music.SongServiceCRUDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final SongServiceCRUDImpl songService;


    @Autowired
    public SongController(SongServiceCRUDImpl songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/songs")
    public ResponseEntity<?> create(@RequestBody Song song) {
        songService.create(song);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "/songs/stop")
    public ResponseEntity<?> delete() {
        songService.destroy();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/songs")
    public ResponseEntity<List<Song>> read() {
        List<Song> list = songService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/songs/{id}")
    public ResponseEntity<Song> read(@PathVariable(name = "id") int id) {
        final Song users = (Song) songService.readById(id);
        return users != null ?
                new ResponseEntity<>(users, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/songs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Song song) {
        final boolean updated = songService.update(song, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/songs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = songService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
