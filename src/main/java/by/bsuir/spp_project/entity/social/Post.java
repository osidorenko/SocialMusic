package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.music.SongData;

import java.util.Date;
import java.util.List;

public class Post {
    private Integer id;
    private Integer authorId;
    private String message;
    private String pngName;
    private Song song;
    private Date date;

    public Post() {
    }

    public Post(Integer id, Integer authorId, String message, String pngName, Song song, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;
        this.song = song;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPngName() {
        return pngName;
    }

    public void setPngName(String pngName) {
        this.pngName = pngName;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
