package com.aashna.BlogApplication.controllers;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable("postId") Integer postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/user/{userId}/posts")
    public List<Post> getPostByUser(@PathVariable Integer userId) {
        return postService.getPostByUser(userId);
    }

    @GetMapping("/posts")
    public List<Post>getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/user/{userId}/posts")
    public String createPost(@RequestBody Post post, @PathVariable Integer userId){
        postService.createPost(post, userId);
        return "Post created Successfully";
    }

    @PutMapping
    public String updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return "Post updated successfully";
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePostDetails(@PathVariable("postId") Integer postId){
        postService.deletePost(postId);
        return "Post Deleted";
    }

    @GetMapping("/posts/search/{keywords}")
    public List<Post> searchPostByTitle(@PathVariable("keywords") String keywords) {
        return postService.searchPosts(keywords);
    }


}

