package by.bsuir.spp_project.dao.secure;

import by.bsuir.spp_project.entity.secure.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    //@Query(value = "SELECT s FROM Comment s where s.authorId = :val ")
    @Query(value = "SELECT s FROM Client s where s.login = :login ")
    public Client readByLogin(@Param("login") String login);

    @Transactional
    @Modifying
    @Query(value = "update clients_data set is_online = true where login = :login", nativeQuery = true)
    public Integer logIn(@Param("login") String login);

    @Transactional
    @Modifying
    @Query(value = "update clients_data set is_online = false where login = :login", nativeQuery = true)
    public Integer logOut(@Param("login") String login);

    @Transactional
    @Modifying
    @Query(value = "update clients_data set is_online = false where id > 0", nativeQuery = true)
    public Integer logOutAll();
}
