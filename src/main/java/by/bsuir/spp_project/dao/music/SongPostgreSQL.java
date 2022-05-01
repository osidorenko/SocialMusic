package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.entity.music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("songDAO")
@Service
public class SongPostgreSQL implements PostgreSQLCRUD<Song> {


    private SongRepository songRepository;

    @Autowired
    public SongPostgreSQL(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public boolean create(Song object) {
        songRepository.save(object);
        return true;
    }

    @Override
    public List<Song> readAll() {
        return songRepository.findAll();
    }

    @Override
    public Song readById(int id) {
        if (songRepository.existsById(id)) {
            return (Song) songRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean update(Song object, int id) {
        Song song = (Song) object;
        if (songRepository.existsById(id)) {
            song.setId(id);
            songRepository.saveAndFlush(song);
            return true;
        }
        return false;
    }

    public int getLast() {
        return 0;
    }

    @Override
    public int count() {
        return (int) songRepository.count();
    }

    @Override
    public boolean delete(int id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int getNext() {
        return 0;
    }
}
