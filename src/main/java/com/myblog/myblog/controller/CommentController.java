package com.myblog.myblog.controller;

import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.payload.PostWithCommentDto;
import com.myblog.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    //http://localhost:8080/api/comments/1
    @PostMapping("/{id}")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @PathVariable long postId){
        CommentDto dto = commentService.createComment(commentDto,postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostWithCommentDto> getAllCommentsByPostId(@PathVariable long postId){
        PostWithCommentDto allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(allCommentsByPostId,HttpStatus.OK);
    }
}
