package by.bsuir.spp_project.entity.music;

import javax.persistence.*;

@Entity
@Table(name = "songsdata")
public class SongData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "songId")
    private Integer songId;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(name = "songName")
    private String songName;

    @Column(name = "pngName")
    private String pngName;

    public SongData() {
    }


    public SongData(Integer id, Integer songId, Integer authorId, String songName, String pngName) {
        this.id = id;
        this.songId = songId;
        this.authorId = authorId;
        this.songName = songName;
        this.pngName = pngName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPngName() {
        return pngName;
    }

    public void setPngName(String pngName) {
        this.pngName = pngName;
    }
}
