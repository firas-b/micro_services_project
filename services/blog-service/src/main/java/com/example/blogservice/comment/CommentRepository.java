package com.example.blogservice.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId(Integer postId);
}
