package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId);
    public PostDto updatePost(PostDto postDto, Integer postId);
    PostDto getPostById(Integer postId);
    List<PostDto> getPostsByUser(Integer userId);
    void deletePost(Integer postId);
    List<PostDto> searchPosts(String keywords);
}
