package com.example.blogger.service.impl;

import com.example.blogger.entity.Comment;
import com.example.blogger.entity.Post;
import com.example.blogger.exception.ResourceNotFoundException;
import com.example.blogger.payload.CommentDto;
import com.example.blogger.repository.CommentRepository;
import com.example.blogger.repository.PostRepository;
import com.example.blogger.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with ID" +postId)
        );
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        comment.setPost(post);
        Comment s = commentRepository.save(comment);
        CommentDto dto = new CommentDto();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setBody(s.getBody());
        dto.setEmail(s.getEmail());
        return dto;
    }
    @Override
    public void deleteComment(long commentId) {
        commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found with id:" + commentId)

        );
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return commentDtos;
    }

    CommentDto mapToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        return dto;
    }

}
