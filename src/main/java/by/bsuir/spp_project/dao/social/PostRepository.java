package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT s FROM Post s where  s.user.id = :val ")
    public List<Post> getByAuthorId(@Param("val") Integer val);

    @Query(value = "select P.id, P.timestamp from Post as P where P.user.id = :user_id order by P.timestamp")
    public List<Object> getPostsByUser(@Param("user_id") Integer user_id);

    @Query(value = "select P.id, P.timestamp from Post as P order by P.timestamp")
    public List<Object> getAllPosts();

    @Query(value = "select P.id, P.timestamp from Post as P where P.message like :pattern order by P.timestamp")
    public List<Object> getAllByPattern(@Param("pattern") String pattern);
}
