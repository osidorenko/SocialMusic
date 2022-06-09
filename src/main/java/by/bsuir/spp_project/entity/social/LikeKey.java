package by.bsuir.spp_project.entity.social;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Data

public class LikeKey implements Serializable {
    static final long serialVersionUID = 1L;
    private Integer user;
    private Integer post;


}
