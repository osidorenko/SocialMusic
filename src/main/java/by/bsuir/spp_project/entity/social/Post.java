package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "message")
    private String message;

    @Column(name = "png_name")
    private String pngName;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "date")
    private Long date;

    public Post() {
    }

    public Post(Integer id, Integer authorId, String message, String pngName, String songName, Long date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;
        this.songName = songName;
        this.date = date;
    }

    public Post(Integer id, Integer authorId, String message, String pngName, String songName, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;
        this.songName = songName;
        //this.date = date;
    }

    public Post(Integer id, Integer authorId, String message, String pngName, String songName) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;
        this.songName = songName;
        this.date = new Date().getTime();
    }

    public Post(Integer id, Integer authorId, String message, String pngName, Song song, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;

        //this.date = date;
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


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"authorId\":" + authorId +
                ", \"message\":\"" + message + '\"' +
                ", \"pngName\":\"" + pngName + '\"' +
                ", \"songName\":\"" + songName + '\"' +
                ", date=" + date +
                '}';
    }
}
