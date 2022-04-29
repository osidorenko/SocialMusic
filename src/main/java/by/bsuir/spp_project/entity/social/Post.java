package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.music.SongM2M;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    @Column(name = "message")
    private String message;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "song_name")
    private String songName;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "timestamp")
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongM2M> songs = new ArrayList<>();


//todo json ignor oneto many likes


    public Post(Integer id) {
        this.id = id;
    }

    public Post() {

    }

    public Post(Integer id, User user, String message, Picture picture, String songName, List<Comment> comments, Timestamp time) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.picture = picture;
        this.songName = songName;
        this.comments = comments;
    }

    public String getDate() {
        return LocalDate.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()).toString();
    }

    public String getTime() {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()).toLocalTime()
                .format(DateTimeFormatter.ofPattern("H:mm:ss"));
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", picture=" + picture +
                ", songName='" + songName + '\'' +
                ", date=" + getDate() +
                ", time=" + getTime() +
                '}';
    }
}
