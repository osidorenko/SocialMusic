package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.SongLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SongLikeRepository extends JpaRepository<SongLike, Integer> {

    @Query(value = "select S from SongLike S where S.user = :user_id")
    public List<SongLike> getAllByUser(@Param("user_id") Integer user_id);

    @Transactional
    @Modifying
    @Query(value = "delete from SongLike s where s.user = :user and s.songData = :song")
    public int deleteLike(@Param("user") int user, @Param("song") int song);

}
