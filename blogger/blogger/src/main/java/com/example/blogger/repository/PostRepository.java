package com.example.blogger.repository;

import com.example.blogger.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post,Long> {

}
