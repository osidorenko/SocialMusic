package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SongDataRepository extends JpaRepository<SongData, Integer> {

    @Query(value = "SELECT s FROM SongData s where s.song.id= :val ")
    public List<SongData> getBySongId(@Param("val") Integer val);

    @Query(value = "SELECT s FROM SongData s where s.user.id = :val ")
    public List<SongData> getByAuthorId(@Param("val") Integer val);

}
