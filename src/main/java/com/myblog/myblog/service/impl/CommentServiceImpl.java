package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.Comment;
import com.myblog.myblog.entity.Post;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.payload.PostWithCommentDto;
import com.myblog.myblog.repository.CommentRepository;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;
    private ModelMapper modelmapper;
    private PostRepository postRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto , long postId){ // giving dto and id
        Optional<Post> byId = postRepository.findById(postId); // with the post id , getting the post
        Post post=byId.get();

        Comment comment=mapToEntity(commentDto);// DTO to Entity
        comment.setPost(post);// Setting comment for the post
        Comment savedComment = commentRepository.save(comment); // saving the post
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    public PostWithCommentDto getAllCommentsByPostId(long id) {
        Post post = postRepository.findById(id).get();
        List<Comment> comments = commentRepository.findByPostId(id);
        List<CommentDto> dtos = comments.stream().map(c-> mapToDto(c)).collect(Collectors.toList());


        PostWithCommentDto postWithCommentDto = new PostWithCommentDto();
        postWithCommentDto.setCommentDto(dtos);
        postWithCommentDto.setPost(post);

        return postWithCommentDto;
    }


    Comment mapToEntity(CommentDto dto){
        Comment comment=modelmapper.map(dto,Comment.class);
        return comment;
    }

    CommentDto mapToDto(Comment comment){
       return modelmapper.map(comment,CommentDto.class);
    }
}
