package com.example.blogger.controller;

import com.example.blogger.payload.CommentDto;
import com.example.blogger.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping("/api/comments")

public class CommentController {

    private CommentService commentService;
    private CommentDto dto;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam("postId") long postId, @RequestBody CommentDto commentDto) {
        CommentDto comment = commentService.createComment(postId, commentDto);
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("comment is deleted!!!",HttpStatus.OK);

    }
    @GetMapping("/{postId}")
    public ResponseEntity <List<CommentDto>>getCommentByPostId(@PathVariable long postId) {
        List<CommentDto> commentDto = commentService.getCommentByPostId(postId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
       List<CommentDto> commentDtos =  commentService.getAllComments();
        return new ResponseEntity<>(commentDtos,HttpStatus.OK);

    }
}
