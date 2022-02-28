package by.bsuir.spp_project.dao.social;

import by.bsuir.spp_project.entity.music.Song;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
