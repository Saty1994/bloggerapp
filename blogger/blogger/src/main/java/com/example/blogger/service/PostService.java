package com.example.blogger.service;

import com.example.blogger.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createpost(PostDto postDto);

    void deletepost(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatePost(long postId, PostDto postDto);
}
