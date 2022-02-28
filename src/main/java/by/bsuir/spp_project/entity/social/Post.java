package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(name = "message")
    private String message;

    @Column(name = "pngName")
    private String pngName;

    @Column(name = "songName")
    private String songName;

    @Column(name = "date")
    private Date date;

    public Post() {
    }


    public Post(Integer id, Integer authorId, String message, String pngName, String songName, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;
        this.songName = songName;
        this.date = date;
    }

    public Post(Integer id, Integer authorId, String message, String pngName, Song song, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.pngName = pngName;

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


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
