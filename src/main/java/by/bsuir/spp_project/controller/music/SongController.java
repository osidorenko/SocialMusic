package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.dao.music.SongPostgreSQL;
import by.bsuir.spp_project.entity.music.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {


    private final SongPostgreSQL songService;

    @Autowired
    public SongController(@Qualifier("songDAO") SongPostgreSQL songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/app/songs")
    public ResponseEntity<?> create(@RequestBody Song song) {
        songService.create(song);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/app/songs")
    public ResponseEntity<List<Song>> read() {
        List<Song> list = songService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/songs/{id}")
    public ResponseEntity<Song> read(@PathVariable(name = "id") int id) {
        final Song users = (Song) songService.readById(id);
        return users != null ?
                new ResponseEntity<>(users, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/app/songs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Song song) {
        final boolean updated = songService.update(song, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/app/songs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = songService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
