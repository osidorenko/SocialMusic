package by.bsuir.spp_project.entity.music;


public class Song {
    private Integer id;
    private String name;
    private String author;
    private Double lasting;
    private Double raiting;
    private Gengre gengre;

    public Song(Integer id, String name, String author, Double lasting) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.lasting = lasting;
        this.gengre = Gengre.DEFAULT;
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
