package by.bsuir.spp_project.entity.social;

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

    @Column(name = "png_name")
    private String pngName;

    public User() {

    }

    public User(Integer id, String name, String pngName) {
        this.id = id;
        this.name = name;
        this.pngName = pngName;
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

    public String getPngName() {
        return pngName;
    }

    public void setPngName(String pngName) {
        this.pngName = pngName;
    }
}
