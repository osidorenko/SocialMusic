package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.social.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from likes_m2m_post where post_id = :post and author_id= :user", nativeQuery = true)
    public int deleteLike(@Param("user") int user, @Param("post") int post);


}
