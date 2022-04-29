package by.bsuir.spp_project.entity.social;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    @Column(name = "timestamp")
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @Column(name = "message")
    private String message;
    @Column(name = "author")
    private String author;


    public Comment() {
    }


    public Comment(Integer id, Post post, User user, Timestamp time, String message, String author) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.timestamp = (time == null ?Timestamp.valueOf(LocalDateTime.now()) : timestamp);
        this.message = message;
        this.author = author;
    }


    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getPost() {
        return post.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return LocalDate.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()).toString();
    }

    public String getTime() {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()).toLocalTime()
                .format(DateTimeFormatter.ofPattern("H:mm:ss"));
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                ", date=" + timestamp +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
