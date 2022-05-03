package by.bsuir.spp_project.controller.music;


import by.bsuir.spp_project.dao.music.SongLikeRepository;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.entity.music.SongLike;
import by.bsuir.spp_project.service.rest.music.SongDataServiceImplCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class SongDataController {

    private final SongDataServiceImplCRUD songDataService;

    @Autowired
    public SongDataController(SongDataServiceImplCRUD songDataService) {
        this.songDataService = songDataService;
    }

    @PostMapping(value = "/app/songs/data")
    public ResponseEntity<?> create(@RequestBody SongData songdata) {
        songDataService.create(songdata);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/app/songs/data")
    public ResponseEntity<List<SongData>> read() {
        List<SongData> list = songDataService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/songs/data/{id}")
    public ResponseEntity<SongData> read(@PathVariable(name = "id") int id) {
        final SongData songData = (SongData) songDataService.readById(id);
        return songData != null ?
                new ResponseEntity<>(songData, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/app/songs/data/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SongData songData) {
        final boolean updated = songDataService.update(songData, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/app/songs/data/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = songDataService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/app/songs/data/to/song/{id}")
    public ResponseEntity<SongData> readToSong(@PathVariable(name = "id") int id) {
        List<SongData> list = songDataService.getByValue("song_id", id);
        SongData songData = (SongData) list.get(list.size() - 1);
        return songData != null ?
                new ResponseEntity<>(songData, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/songs/data/to/author/{id}")
    public ResponseEntity<List<SongData>> readToAuthor(@PathVariable(name = "id") int id) {
        List<SongData> list = songDataService.getByValue("author_id", id);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Autowired
    private SongLikeRepository songLikeRepository;

    @GetMapping(value = "/app/songs/data/likes/to/author/{id}")
    public ResponseEntity<List<SongData>> readToAuthorLikes(@PathVariable(name = "id") int id) {
        List<SongLike> likes = songLikeRepository.getAllByUser(id);
        List<SongData> list = new ArrayList<>();
        Iterator<SongLike> iterator = likes.iterator();
        while (iterator.hasNext()) {
            SongLike next = iterator.next();
            list.add(songDataService.readById(next.getSongData()));
        }
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
