package com.example.blogservice.post;

import com.example.blogservice.user.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postrepo;
    private final UserClient userClient;
    private final PostMapper postMapper;


    public String createPost(PostRequest request) {
        var users = userClient.findUserById(request.author()).orElseThrow(() -> new RuntimeException("Cannot create post:: No user exists with the provided ID"));

        return postrepo.save(postMapper.toPost(request)).getTitle();

    }


    public List<PostResponse> getPosts() {

        return postrepo.findAll().stream().map(postMapper::toPostResponse).collect(Collectors.toList());
    }
}


