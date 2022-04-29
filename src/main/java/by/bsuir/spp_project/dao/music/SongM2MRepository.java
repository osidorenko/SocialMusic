package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.SongM2M;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SongM2MRepository extends JpaRepository<SongM2M, Integer> {

}
