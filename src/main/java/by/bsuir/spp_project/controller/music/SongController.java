package by.bsuir.spp_project.controller.music;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.service.rest.music.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class SongController {
    private final SongServiceImpl songService;

    @Autowired
    public SongController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/songs")
    public ResponseEntity<?> create(@RequestBody Song song) {
        songService.create(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/songs")
    public ResponseEntity<List<Song>> read() {

        final List<Song> songs = new ArrayList<>();
        List list = songService.readAll();
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                songs.add((Song) iterator.next());
            }
        }
        return !songs.isEmpty() ?
                new ResponseEntity<>(songs, HttpStatus.OK) :
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