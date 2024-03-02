package com.myblog.myblog.service;

import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.payload.PostWithCommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);
    public PostWithCommentDto getAllCommentsByPostId(long id);

}
