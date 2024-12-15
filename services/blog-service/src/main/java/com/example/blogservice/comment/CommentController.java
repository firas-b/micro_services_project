package com.example.blogservice.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<String> createComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok(commentService.creteComment(commentRequest));
    }
    @GetMapping("/byPost/{post-id}")
    public ResponseEntity<List<CommentResponse>> getCommentsbypost(@PathVariable("post-id") Integer postId) {
        return ResponseEntity.ok(commentService.getCommentsbyPstId(postId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Integer id) {
       return  ResponseEntity.ok(commentService.deleteComment(id));
    }

}
