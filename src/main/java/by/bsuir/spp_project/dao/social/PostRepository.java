package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT s FROM Post s where  s.authorId = :val ")
    public List<Post> getByAuthorId(@Param("val") Integer val);
}
