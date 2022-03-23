package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.files.Picture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Post")
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User user;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "song_name")
    private String songName;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();

    @Column(name = "date")
    private Long date;

    public Post() {
    }

    public Post(Integer id, User user, String message, Picture picture, String songName, List<Comment> comments, Long date) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.picture = picture;
        this.songName = songName;
        this.comments = comments;
        this.date = date;
    }

    public Post(Integer id, User user, String message, Picture picture, String songName, Long date) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.picture = picture;
        this.songName = songName;
        this.date = new Date().getTime();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", picture=" + picture +
                ", songName='" + songName + '\'' +
                ", comments=" + comments +
                ", date=" + date +
                '}';
    }
}
