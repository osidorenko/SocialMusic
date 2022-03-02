package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    //toauthor
    //topost
    @Query(value = "SELECT s FROM Comment s where s.postId = :val ")
    public List<Comment> getByPostId(@Param("val") Integer val);

    @Query(value = "SELECT s FROM Comment s where s.authorId = :val ")
    public List<Comment> getByAouthorId(@Param("val") Integer val);
}
