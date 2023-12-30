package com.example.blogger.service;

import com.example.blogger.payload.CommentDto;

import java.util.List;

public interface CommentService {



    public CommentDto createComment(long postId, CommentDto commentDto);

    void deleteComment(long commentId);

    List<CommentDto> getCommentByPostId(long postId);


    List<CommentDto> getAllComments();
}