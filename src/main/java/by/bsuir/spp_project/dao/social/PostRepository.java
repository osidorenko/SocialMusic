package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
