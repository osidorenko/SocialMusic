package by.bsuir.spp_project.entity.social;

import javax.persistence.*;

@Entity
@Table(name = "likes_m2m_post")
public class Like {

    @Id
    @Column(name = "id")

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "li")
    private byte like;

    public Like() {
    }

    public Like(Integer id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public Like(Integer id, User user, Post post, byte like) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.like = like;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPost() {
        return post.getId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public byte getLike() {
        return like;
    }

    public void setLike(byte like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
