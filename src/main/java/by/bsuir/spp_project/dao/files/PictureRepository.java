package by.bsuir.spp_project.dao.files;

import by.bsuir.spp_project.entity.files.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

@Repository("pictureRepository")
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE public.pictures SET name = :name WHERE id = :id", nativeQuery = true)
    public void updatePic(@Param("id") Integer id, @Param("name") String name);
}
