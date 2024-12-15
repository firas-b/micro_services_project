package com.example.blogservice.comment;


import lombok.Builder;

@Builder
public record CommentResponse(
        Long id,
        String author,
        String Content
) {
}
