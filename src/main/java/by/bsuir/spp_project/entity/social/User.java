package by.bsuir.spp_project.entity.social;

public class User {
    private Integer id;
    private String name;
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
