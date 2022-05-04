package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    @Query(value = "select * from songs where name like :pattern", nativeQuery = true)
    public List<Song> getAllByPatternName(@Param("pattern") String pattern);

    @Query(value = "select * from songs where author like :pattern", nativeQuery = true)
    public List<Song> getAllByPatternAuthor(@Param("pattern") String pattern);
}
