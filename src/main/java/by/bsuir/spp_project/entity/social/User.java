package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.files.Picture;
import by.bsuir.spp_project.entity.music.SongData;
import by.bsuir.spp_project.entity.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users_data")
public class User {
    //todo normal types for any tables of db and test all function

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "picture_id")
    private Picture picture;


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongData> songs = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();


    //todo json ignor oneto many likes


    public User(Integer id) {
        this.id = id;
    }

    public User() {

    }

    public User(Integer id, String name, Picture picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public User(Integer id, String name, String pngName) {
        this.id = id;
        this.name = name;

    }
}
