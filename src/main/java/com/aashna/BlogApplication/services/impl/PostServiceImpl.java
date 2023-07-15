package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.payloads.PostDto;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.repositories.UserRepo;
import com.aashna.BlogApplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId) {

        User user = this.userRepo.findById(userId).get();
        Post post = this.modelMapper.map(postDto, Post.class);

        post.setAddedDate(new Date());
        post.setUser(user);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    // UPDATE
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId).get();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    // Delete by id
    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).get();
        this.postRepo.delete(post);

    }

    // GET POST BY ID
    @Override
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId).get();
        return this.modelMapper.map(post, PostDto.class);
    }

    // getPostsByUser
    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId).get();
        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keywords) {

        List<Post> posts = this.postRepo.searchByTitle("%" + keywords + "%");

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }
}
