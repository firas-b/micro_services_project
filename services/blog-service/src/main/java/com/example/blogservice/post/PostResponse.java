package com.example.blogservice.post;

import com.example.blogservice.comment.CommentResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PostResponse(

        int id,
        String title,
        String content,
        String author,
        String photo
       // List<CommentResponse> comments
) {
}
