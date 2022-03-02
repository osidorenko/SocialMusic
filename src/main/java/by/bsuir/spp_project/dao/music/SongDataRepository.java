package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SongDataRepository extends JpaRepository<SongData, Integer> {
    /*
    * @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(
  @Param("status") Integer status,
  @Param("name") String name);*/
    @Query(value = "SELECT s FROM SongData s where s.songId= :val ")
    public List<SongData> getBySongId(@Param("val") Integer val);

    @Query(value = "SELECT s FROM SongData s where s.authorId = :val ")
    public List<SongData> getByAuthorId(@Param("val") Integer val);

}
