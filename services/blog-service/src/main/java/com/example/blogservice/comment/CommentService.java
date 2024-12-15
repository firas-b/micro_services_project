package com.example.blogservice.comment;


import com.example.blogservice.exception.BusinessException;
import com.example.blogservice.post.Post;
import com.example.blogservice.post.PostRepository;
import com.example.blogservice.user.UserClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserClient userClient;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;

    public String creteComment(CommentRequest comment) {
        var user = userClient.findUserById(comment.author()).orElseThrow(() -> new BusinessException("user not found with id " + comment.author() ));
        return commentRepository.save(commentMapper.tocomment(comment)).toString();
    }
    public List<CommentResponse> getCommentsbyPstId(int postId) {
        return commentRepository.findByPostId(postId).stream().map(
                commentMapper::tocommentResponse
        ).collect(Collectors.toList());
    }
    public CommentResponse getCommentById(int commentId) {
        return commentMapper.tocommentResponse(commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("comment not found with id " + commentId)))    ;
    }
    public String deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return "Comment deleted";
    }

}