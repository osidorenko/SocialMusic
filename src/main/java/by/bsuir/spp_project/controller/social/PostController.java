package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.controller.file.ResponseMessage;
import by.bsuir.spp_project.dao.social.PostPostgreSQL;
import by.bsuir.spp_project.dao.social.PostRepository;
import by.bsuir.spp_project.entity.social.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Qualifier("postDAO")
    @Autowired
    private final PostPostgreSQL postService;

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    public PostController(
            @Qualifier("postDAO") PostPostgreSQL postService,
            PostRepository postRepository
    ) {
        this.postService = postService;
        this.postRepository = postRepository;
    }


    @PostMapping(value = "/app/posts")
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.create(post);
        int last = postService.getLast();
        if (last != 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(last);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/app/posts")

    public ResponseEntity<List<Post>> read() {
        List<Post> list = postService.readAll();
        //ResponseEntity<List<Post>> entity = ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(list);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/app/posts/{id}")
    public ResponseEntity<Post> read(@PathVariable(name = "id") int id) {
        final Post post = postService.readById(id);
        return post != null ?
                new ResponseEntity<>(post, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/app/posts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Post post) {
        final boolean updated = postService.update(post, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/app/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = postService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping(value = "/app/posts/to/author/{id}")
    public ResponseEntity<List<Object>> readToAuthor(@PathVariable(name = "id") int id) {
        List<Object> list = postRepository.getPostsByUser(id);
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/posts/all")
    public ResponseEntity<List<Object>> readToAuthor() {
        List<Object> list = postRepository.getAllPosts();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/posts/by/pattern/{pattern}")
    public ResponseEntity<List<Object>> readByPatter(@PathVariable(name = "pattern") String pattern) {
        List<Object> list = postRepository.getAllByPattern(pattern + "%");
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
