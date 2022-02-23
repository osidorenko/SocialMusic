package by.bsuir.spp_project.entity;


public class Song {
    private Integer id;
    private String name;
    private String author;
    private Double lasting;
    private Gengre gengre;

    public Song(Integer id, String name, String author, Integer authorId, Double lasting) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.lasting = lasting;
        this.gengre = Gengre.DEFAULT;
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

    public Gengre getGengre() {
        return gengre;
    }

    public void setGengre(Gengre gengre) {
        this.gengre = gengre;
    }
}
