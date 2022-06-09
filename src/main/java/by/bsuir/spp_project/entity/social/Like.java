package by.bsuir.spp_project.entity.social;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "likes_m2m_post")
@Data
@IdClass(LikeKey.class)
public class Like {

    @Id
    @Column(name = "author_id")
    private Integer user;

    @Id
    @Column(name = "post_id")
    private Integer post;

    @Column(name = "li")
    private byte like;

    public Like() {
    }

    public Like(Integer user, Integer post, byte like) {
        this.user = user;
        this.post = post;
        this.like = like;
    }

}
