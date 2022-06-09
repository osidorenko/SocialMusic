package by.bsuir.spp_project.entity.music;

import by.bsuir.spp_project.entity.social.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Data
public class SongLikeKey implements Serializable {
    static final long serialVersionUID = 1L;
    private Integer user;
    private Integer songData;

}
