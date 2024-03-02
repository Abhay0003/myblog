package com.myblog.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myblog.myblog.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostId(long postId);

}
