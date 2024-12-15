package com.example.blogservice.comment;


import com.example.blogservice.post.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {


    public Comment tocomment(CommentRequest request) {
        return  Comment.builder()
                        .author(request.author())
                        .post(Post.builder().id(request.postId()).build())
                        .content(request.Content())
                        .build();
    }

    public  CommentResponse tocommentResponse(Comment comment) {

        return CommentResponse.builder().
                author(comment.getAuthor())
                .Content(comment.getContent())
                .build();


    }
}
