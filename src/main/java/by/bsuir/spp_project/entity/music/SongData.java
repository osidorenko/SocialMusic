package by.bsuir.spp_project.entity.music;

import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.social.User;

import javax.persistence.*;

@Entity
@Table(name = "songs_data")
public class SongData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User user;


    @Column(name = "song_name")
    private String songName;

    @OneToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    //todo repository for pictures!!!!! and may be songs
    /*
    @Column(name = "png_name")
    private String png_name;
*/
    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public Song getSong() {
        return song;
    }

    public SongData() {
    }

    public SongData(Integer id, User user, String songName, Picture picture, Song song) {
        this.id = id;
        this.user = user;
        this.songName = songName;
        this.picture = picture;
        this.song = song;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setSong(Song song) {
        this.song = song;
    }

}
