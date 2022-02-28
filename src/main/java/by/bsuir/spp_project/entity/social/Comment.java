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
    @Column(name = "postId")
    private Integer postId;
    @Column(name = "authorId")
    private Integer authorId;
    @Column(name = "date")
    private Date date;
    @Column(name = "message")
    private String message;
    @Column(name = "author")
    private String author;

    public Comment() {

    }

    public Comment(Integer id, Integer postId, Integer authorId, Date date, String message, String author) {
        this.id = id;
        this.postId = postId;
        this.authorId = authorId;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
