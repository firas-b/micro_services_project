package com.example.blogservice.post;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component

public class PostMapper {


    public   Post toPost(PostRequest postRequest) {

        return  Post.builder()
                         .title(postRequest.title())
                         .author(postRequest.author())
                         .content(postRequest.content())
                         .build();
    }

    public PostResponse toPostResponse(Post post) {

        return new PostResponse(
               post.getTitle(), post.getContent(), post.getAuthor(), post.getPhoto()
        );
    }
}
