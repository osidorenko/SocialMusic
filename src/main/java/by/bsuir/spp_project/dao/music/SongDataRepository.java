package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.music.SongData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDataRepository extends JpaRepository<SongData, Integer> {

}
