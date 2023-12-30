package com.example.blogger.service.impl;

import com.example.blogger.entity.Post;
import com.example.blogger.exception.ResourceNotFoundException;
import com.example.blogger.payload.PostDto;
import com.example.blogger.repository.PostRepository;
import com.example.blogger.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    private PostRepository postRepo;

    @Override
    public  PostDto createpost(PostDto postDto) {


        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());

       Post savedPost = postRepo.save(post);
       PostDto dto = new PostDto();
       dto.setId(savedPost.getId());
       dto.setTitle(savedPost.getTitle());
       dto.setContent(savedPost.getContent());
       dto.setDescription(savedPost.getDescription());

       return dto;

    }

    @Override
    public void deletepost(long id) {
        postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post now found with id: " + id)


        );

        postRepo.deleteById(id);
    }
//sortby coverts string to sort
    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
//        Sort.Direction asc = Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepo.findAll(pageable);
        List<Post> posts = pagePosts.getContent();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public PostDto updatePost(long postId, PostDto postDto) {

        Post post = postRepo.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id: "+postId)
        );
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(post.getContent());

        Post savePost = postRepo.save(post);

        PostDto dto = mapToDto(savePost);
        return dto;
    }

    PostDto mapToDto(Post post) {

    PostDto dto = new PostDto();
    dto.setId(post.getId());
    dto.setTitle(post.getTitle());
    dto.setContent(post.getContent());
    dto.setDescription(post.getDescription());
    return dto;
}

}


