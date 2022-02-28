package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {

}
