package by.bsuir.spp_project.entity.view;

import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Immutable
@Entity
@Subselect("select posts.id postId, users_data.name authorName from posts inner join users_data on posts.author_id = users_data.id ")
@Synchronize({"posts", "users_data"})
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class View {
    @Id
    @ToString.Include
    private Integer postId;

    @ToString.Include
    private String authorName;
}
