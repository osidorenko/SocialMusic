package by.bsuir.spp_project.entity.files;

import by.bsuir.spp_project.entity.music.SongData;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Picture() {
    }

    public Picture(Integer id, String name) {
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
}
