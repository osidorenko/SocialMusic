package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.service.rest.social.CommentServiceCRUDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CommentController {
    //todo test!!!
    private final CommentServiceCRUDImpl commentService;

    @Autowired
    public CommentController(CommentServiceCRUDImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        commentService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> read() {
        List<Comment> list = commentService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> read(@PathVariable(name = "id") int id) {
        final Comment com = commentService.readById(id);
        return com != null ?
                new ResponseEntity<>(com, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/comments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Comment com) {
        final boolean updated = commentService.update(com, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/comments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = commentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/comments/to/author/{id}")
    public ResponseEntity<List<Comment>> readToAuthor(@PathVariable(name = "id") int id) {
        Object o = commentService.getByValue("author_id", id);
        final List<Comment> comments = new ArrayList<>();
        List list = (List) o;
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                comments.add((Comment) iterator.next());
            }
        }
        return !comments.isEmpty() ?
                new ResponseEntity<>(comments, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/comments/to/post/{id}")
    public ResponseEntity<List<Comment>> readToPost(@PathVariable(name = "id") int id) {
        Object o = commentService.getByValue("post_id", id);
        final List<Comment> comments = new ArrayList<>();
        List list = (List) o;
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                comments.add((Comment) iterator.next());
            }
        }
        return !comments.isEmpty() ?
                new ResponseEntity<>(comments, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
