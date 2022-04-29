package by.bsuir.spp_project.entity.secure;

import by.bsuir.spp_project.entity.social.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

@Data
@Entity
@Table(name = "clients_data")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "login")
    private String login;

    @Column(name = "h_pass")
    private String hpass;


    @Column(name = "is_online")
    private boolean isOnline;

    public Client() {

    }

    public Client(String login) {
        this.login = login;
    }

    public Client(Integer id, User userId, String login, String hpass, boolean isOnline) {
        this.id = id;
        this.userId = userId;
        this.login = login;
        this.hpass = hpass;
        this.isOnline = isOnline;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userId=" + userId +
                ", login='" + login + '\'' +
                ", hpass=" + hpass +
                ", isOnline=" + isOnline +
                '}';
    }

    public UserDetails details(){
        return new org.springframework.security.core.userdetails.User(getLogin(), getHpass(),  true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}

