package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
