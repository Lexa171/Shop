package by.onlineStore.controller;

import by.onlineStore.dto.CommentDto;
import by.onlineStore.dto.CreateCommentDto;
import by.onlineStore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(value = {"/comment"}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ResponseEntity<List<CommentDto>> getAllComment() {

        return ResponseEntity.ok(commentService.getAllComments());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommentDto> getComment(@PathVariable("id") Long id) {

        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentDto> addComment(@RequestBody CreateCommentDto createCommentDto) {

        return ResponseEntity.ok(commentService.saveComment(createCommentDto));
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto) {

        return ResponseEntity.ok(commentService.updateComment(commentDto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);

        return ResponseEntity.ok().build();
    }

}
