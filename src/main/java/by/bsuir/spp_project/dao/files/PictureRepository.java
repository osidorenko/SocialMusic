package by.bsuir.spp_project.dao.files;

import by.bsuir.spp_project.entity.files.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
