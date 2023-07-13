package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;

import java.util.List;

public interface PostService {
    public String createPost(Post post);
    public String updatePost(Post post);
    public Post getPostById(Integer postId);
    public String deletePost(Integer postId);
    public List<Post> getAllPosts();
}
