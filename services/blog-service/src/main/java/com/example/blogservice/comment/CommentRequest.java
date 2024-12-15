package com.example.blogservice.comment;

public record CommentRequest(

        int postId,
        String author,
        String Content
) {
}
