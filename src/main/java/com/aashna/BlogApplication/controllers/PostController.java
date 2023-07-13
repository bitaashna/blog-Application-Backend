package com.aashna.BlogApplication.controllers;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("{postId}")
    public Post getPost(@PathVariable("postId") Integer postId) {
        return postService.getPostById(postId);
    }

    @GetMapping()
    public List<Post>getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public String createPost(@RequestBody Post post){
        postService.createPost(post);
        return "Post created Successfully";
    }

    @PutMapping
    public String updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return "Post updated successfully";
    }

    @DeleteMapping("{postId}")
    public String deletePostDetails(@PathVariable("postId") Integer postId){
        postService.deletePost(postId);
        return "Post Deleted";
    }
}

