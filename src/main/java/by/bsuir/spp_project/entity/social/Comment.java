package by.bsuir.spp_project.entity.social;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "date")
    private Long date;
    @Column(name = "message")
    private String message;
    @Column(name = "author")
    private String author;

    public Comment() {

    }


    public Comment(Integer id, Integer postId, Integer authorId, Long date, String message, String author) {
        this.id = id;
        this.postId = postId;
        this.authorId = authorId;
        this.date = date;
        this.message = message;
        this.author = author;
    }

    public Comment(Integer id, Integer postId, Integer authorId, String message, String author) {
        this.id = id;
        this.postId = postId;
        this.authorId = authorId;
        this.date = new Date().getTime();
        this.message = message;
        this.author = author;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
