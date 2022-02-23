package by.bsuir.spp_project.controller.social;


import by.bsuir.spp_project.entity.social.Comment;
import by.bsuir.spp_project.service.rest.social.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CommentController {
    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        commentService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> read() {

        final List<Comment> songsdata = new ArrayList<>();
        List list = commentService.readAll();
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                songsdata.add((Comment) iterator.next());
            }
        }
        return !songsdata.isEmpty() ?
                new ResponseEntity<>(songsdata, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> read(@PathVariable(name = "id") int id) {
        final Comment com = (Comment) commentService.readById(id);
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

    //todo comments for author and post ect... see class
    @GetMapping(value = "/comments/toauthor/{id}")
    public ResponseEntity<Comment> readToAuthor(@PathVariable(name = "id") int id) {
        return null;
    }

    @GetMapping(value = "/comments/topost/{id}")
    public ResponseEntity<Comment> readToPost(@PathVariable(name = "id") int id) {
        return null;
    }
}
