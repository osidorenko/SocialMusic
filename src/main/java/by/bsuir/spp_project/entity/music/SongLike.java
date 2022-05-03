package by.bsuir.spp_project.entity.music;

import by.bsuir.spp_project.entity.social.User;

import javax.persistence.*;

@Entity
@Table(name = "likes_m2m_song")
public class SongLike {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "song_data_id")
    private SongData songData;

    public SongLike() {

    }

    public SongLike(Integer id, User user, SongData songData) {
        this.id = id;
        this.user = user;
        this.songData = songData;
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

    public Integer getSongData() {
        return songData.getId();
    }

    public void setSongData(SongData songData) {
        this.songData = songData;
    }
}
