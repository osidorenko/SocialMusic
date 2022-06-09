package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.dao.social.UserPostgreSQL;
import by.bsuir.spp_project.dao.social.UserRepository;
import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserRepository userRepository;

    private final UserPostgreSQL userService;

    @Autowired
    public UserController(
            UserRepository userRepository,
            @Qualifier("userDAO") UserPostgreSQL userService
    ) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PostMapping(value = "/app/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/app/users")
    public ResponseEntity<List<User>> read() {
        List<User> list = userService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        final User user = userService.readById(id);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/app/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
        final boolean updated = userService.update(user, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/app/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/app/users/by/pattern/{pattern}")
    public ResponseEntity<List<User>> readByPatter(@PathVariable(name = "pattern") String pattern) {
        List<User> list = userRepository.getAllByPattern(pattern + "%");
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
