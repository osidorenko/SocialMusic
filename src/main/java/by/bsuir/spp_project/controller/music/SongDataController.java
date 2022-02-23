package by.bsuir.spp_project.controller.music;


import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.service.rest.music.SongDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class SongDataController {

    private final SongDataServiceImpl songDataService;

    @Autowired
    public SongDataController(SongDataServiceImpl songDataService) {
        this.songDataService = songDataService;
    }

    @PostMapping(value = "/songs/data")
    public ResponseEntity<?> create(@RequestBody SongData songdata) {
        songDataService.create(songdata);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/songs/data")
    public ResponseEntity<List<SongData>> read() {

        final List<SongData> songsdata = new ArrayList<>();
        List list = songDataService.readAll();
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                songsdata.add((SongData) iterator.next());
            }
        }
        return !songsdata.isEmpty() ?
                new ResponseEntity<>(songsdata, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/songs/data/{id}")
    public ResponseEntity<SongData> read(@PathVariable(name = "id") int id) {
        final SongData songData = (SongData) songDataService.readById(id);
        return songData != null ?
                new ResponseEntity<>(songData, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/songs/data/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SongData songData) {
        final boolean updated = songDataService.update(songData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/songs/data/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = songDataService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //todo release methods for id song
    @GetMapping(value = "/songs/data/tosong/{id}")
    public ResponseEntity<SongData> readToSong(@PathVariable(name = "id") int id) {
        return null;
    }
}
