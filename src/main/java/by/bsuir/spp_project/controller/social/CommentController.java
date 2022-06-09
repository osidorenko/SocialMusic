package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.dao.social.CommentPostgreSQL;
import by.bsuir.spp_project.entity.social.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CommentController {

    private final CommentPostgreSQL commentService;

    @Autowired
    public CommentController(@Qualifier("commentDAO") CommentPostgreSQL commentService) {
        this.commentService = commentService;
    }


    @PostMapping(value = "/app/comments")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        commentService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/app/comments")
    public ResponseEntity<List<Comment>> read() {
        List<Comment> list = commentService.readAll();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/app/comments/{id}")
    public ResponseEntity<Comment> read(@PathVariable(name = "id") int id) {
        final Comment com = commentService.readById(id);
        return com != null ?
                new ResponseEntity<>(com, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/app/comments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Comment com) {
        final boolean updated = commentService.update(com, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/app/comments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = commentService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/app/comments/to/author/{id}")
    public ResponseEntity<List<Comment>> readToAuthor(@PathVariable(name = "id") int id) {
        List<Comment> comments = commentService.getByValue("author_id", id);
        return !comments.isEmpty() ?
                new ResponseEntity<>(comments, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/app/comments/to/post/{id}")
    public ResponseEntity<List<Comment>> readToPost(@PathVariable(name = "id") int id) {
        List<Comment> comments = commentService.getByValue("post_id", id);
        return !comments.isEmpty() ?
                new ResponseEntity<>(comments, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
