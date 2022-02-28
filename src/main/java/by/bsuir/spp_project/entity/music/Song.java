package by.bsuir.spp_project.entity.music;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "lasting")
    private Double lasting;

    @Column(name = "raiting")
    private Double raiting;

    @Column(name = "gengre")
    private String gengre;

    public Song(Integer id, String name, String author, Double lasting) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.lasting = lasting;
        this.gengre = Gengre.DEFAULT.toString();
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    public Song(Integer id, String name, String author, Double lasting, Double raiting) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.lasting = lasting;
        this.raiting = raiting;
        this.gengre = Gengre.DEFAULT.toString();
    }

    public Song() {

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getLasting() {
        return lasting;
    }

    public void setLasting(Double lasting) {
        this.lasting = lasting;
    }

    public String getGengre() {
        return gengre;
    }

    public void setGengre(String gengre) {
        this.gengre = gengre;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"author\":\"" + author + '\"' +
                ", \"lasting\":" + lasting +
                ", \"raiting\":" + raiting +
                ", \"gengre\":\"" + gengre + '\"' +
                '}';
    }
}
