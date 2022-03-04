package by.bsuir.spp_project.entity.secure;

import javax.persistence.*;
import java.util.Arrays;
import java.util.BitSet;

@Entity
@Table(name = "clients_data")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login")
    private String login;

    @Column(name = "h_pass")
    private char[] hpass;

    @Column(name = "is_online")
    private boolean isOnline;

    public Client() {

    }

    public Client(String login) {
        this.login = login;
    }

    public Client(Integer id, Integer userId, String login, char[] hpass) {
        this.id = id;
        this.userId = userId;
        this.login = login;
        this.hpass = hpass;
    }

    public Client(Integer id, String login, char[] hpass) {
        this.id = id;
        this.login = login;
        this.hpass = hpass;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getHpass() {
        return hpass;
    }

    public void setHpass(char[] hpass) {
        this.hpass = hpass;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userId=" + userId +
                ", login='" + login + '\'' +
                ", hpass=" + Arrays.toString(hpass) +
                ", isOnline=" + isOnline +
                '}';
    }
}
