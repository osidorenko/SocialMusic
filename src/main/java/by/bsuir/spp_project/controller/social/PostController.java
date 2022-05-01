package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.dao.social.PostRepository;
import by.bsuir.spp_project.entity.social.Post;
import by.bsuir.spp_project.service.rest.social.PostServiceCRUDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin
public class PostController {
    private final PostServiceCRUDImpl postService;

    @Autowired
    public PostController(PostServiceCRUDImpl postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts")
    //@CrossOrigin
    public ResponseEntity<List<Post>> read() {
        List<Post> list = postService.readAll();
        //ResponseEntity<List<Post>> entity = new ResponseEntity<>(list, HttpStatus.OK);

        ResponseEntity<List<Post>> entity = ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(list);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                //entity :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@CrossOrigin
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> read(@PathVariable(name = "id") int id) {
        final Post post = postService.readById(id);
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


    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/posts/to/author/{id}")
    public ResponseEntity<List<Object>> readToAuthor(@PathVariable(name = "id") int id) {
        List<Object> list = postRepository.getPostsByUser(id);
        //List<Post> list = postService.getByValue("author_id", id);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
