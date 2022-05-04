package by.bsuir.spp_project.entity.music;

import by.bsuir.spp_project.entity.social.Post;

import javax.persistence.*;

@Entity
@Table(name = "songs_m2m_post")
public class SongM2M {
    @Id
    @Column(name = "id")

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "song_data_id")
    private SongData songData;


    public SongM2M(Integer id, Post post, SongData songData) {
        this.id = id;
        this.post = post;
        this.songData = songData;
    }

    public SongM2M() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPost() {
        return post.getId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public SongData getSongData() {
        return songData;
    }

    public void setSongData(SongData songData) {
        this.songData = songData;
    }
}
