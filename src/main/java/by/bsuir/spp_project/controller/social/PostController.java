package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.service.rest.social.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> read() {

        final List<Post> songsdata = new ArrayList<>();
        List list = postService.readAll();
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                songsdata.add((Post) iterator.next());
            }
        }
        return !songsdata.isEmpty() ?
                new ResponseEntity<>(songsdata, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> read(@PathVariable(name = "id") int id) {
        final Post post = (Post) postService.readById(id);
        return post != null ?
                new ResponseEntity<>(post, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Post post) {
        final boolean updated = postService.update(post, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = postService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //todo posts toauthor
    @GetMapping(value = "/posts/toauthor/{id}")
    public ResponseEntity<Post> readToAuthor(@PathVariable(name = "id") int id) {
        return null;
    }

}
