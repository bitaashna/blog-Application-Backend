package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.model.Post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post, Integer userId);
    public String updatePost(Post post);
    public Post getPostById(Integer postId);
    public List<Post> getPostByUser(Integer userId);
    public String deletePost(Integer postId);
    public List<Post> getAllPosts();

    public List<Post> searchPosts(String keywords);
}
