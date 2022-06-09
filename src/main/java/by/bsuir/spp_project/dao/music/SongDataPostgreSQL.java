package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.dao.PostgreSQLCRUD;
import by.bsuir.spp_project.dao.PostgreSQLgetByValue;
import by.bsuir.spp_project.dao.files.PictureRepository;
import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.music.SongData;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

    @Repository("songDataDAO")
public class SongDataPostgreSQL implements PostgreSQLCRUD<SongData>, PostgreSQLgetByValue<SongData> {


    private SongDataRepository songDataRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    public SongDataPostgreSQL(SongDataRepository songDataRepository) {
        this.songDataRepository = songDataRepository;
    }

    @Override
    public boolean create(SongData object) {
        //todo ref this shit
        try {
            object.setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + LocalTime.now().getHour() * 13);
            object.getSong().setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + LocalTime.now().getHour() * 17);
            Song s = songRepository.save(object.getSong());
            object.getPicture().setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + LocalTime.now().getHour() * 17 + 2);
            while (pictureRepository.existsById(object.getPicture().getId())) {
                object.getPicture().setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + 1);
                System.err.println("picture set ID songData");
            }
            Picture picture = pictureRepository.save(object.getPicture());
            object.setPicture(picture);
            object.setSong(s);
            try {
                object.setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7 + LocalTime.now().getHour() * 17 + 19);
                SongData songData = songDataRepository.save((SongData) object);
            } catch (Exception e) {
                object.setId((LocalTime.now().getMinute() + LocalTime.now().getSecond() * 3) * 7);
                SongData songData = songDataRepository.save((SongData) object);
                e.printStackTrace();
            }
            return true;
        } catch (JDBCException e) {
            return false;
        }
    }

    @Override
    public int count() {
        return (int) songDataRepository.count();
    }

    @Override
    public List<SongData> readAll() {
        return songDataRepository.findAll();
    }

    @Override
    public SongData readById(int id) {
        if (songDataRepository.existsById(id)) {
            return songDataRepository.findById(id).get();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean update(SongData object, int id) {
        if (songDataRepository.existsById(id)) {
            SongData songdata = (SongData) object;
            songdata.setId(id);
            songDataRepository.saveAndFlush(songdata);
            return true;
        }
        return false;
    }


    @Override
    public List<SongData> getByValue(String column, Integer value) {
        List<SongData> o = new ArrayList();
        if (column.equals("song_id")) {
            o = songDataRepository.getSongDataBySong_Id(value);
        } else {
            if (column.equals("author_id")) {
                o = songDataRepository.getByAuthorId(value);
            }
        }
        return o;
    }

    @Override
    public boolean delete(int id) {
        if (songDataRepository.existsById(id)) {
            songDataRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int getNext() {
        return songDataRepository.getNext() + 1;
    }
}
