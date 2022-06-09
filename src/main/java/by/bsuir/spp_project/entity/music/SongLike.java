package by.bsuir.spp_project.entity.music;

import by.bsuir.spp_project.entity.social.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "likes_m2m_song")
@IdClass(SongLikeKey.class)
@Data
public class SongLike {

    @Id
    @Column(name = "author_id")
    private Integer user;

    @Id
    @Column(name = "song_data_id")
    private Integer songData;

    public SongLike() {

    }

    public SongLike(Integer user, Integer songData) {
        this.user = user;
        this.songData = songData;
    }
}
