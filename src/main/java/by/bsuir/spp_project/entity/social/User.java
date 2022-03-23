package by.bsuir.spp_project.entity.social;

import by.bsuir.spp_project.entity.files.Picture;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
