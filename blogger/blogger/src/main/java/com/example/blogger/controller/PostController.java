package com.example.blogger.controller;


import com.example.blogger.payload.PostDto;
import com.example.blogger.postDto;
import com.example.blogger.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createpost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto dto = postService.createpost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletepost(id);
        return new ResponseEntity<>("post is deleted!!!", HttpStatus.OK);

    }

    // http://Localhost:8080/api/posts/pageNo=0&pageSize=5&soryBy=title&sortBy=desc
    @GetMapping
   public ResponseEntity<List<PostDto>> getAllPosts(
           @RequestParam(name="pageNo", defaultValue = "0", required = false) int pageNo,
           @RequestParam(name = "pageSize", defaultValue = "3",required = false) int pageSize,
           @RequestParam(name = "SoryBy", defaultValue = "id", required = false) String sortBy,
           @RequestParam(name = "sortDir", defaultValue = "asc", required = false) String sortDir

    ) {


        List<PostDto> postDtos =postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);


   }
    // http:localhost:8080/api/posts?postId=1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<PostDto> updatePost(
            @RequestParam("postId") long postId,
            @RequestBody PostDto postDto
    ) {

        PostDto dto = postService.updatePost(postId, postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

}


