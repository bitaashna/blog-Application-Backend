package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.exceptions.ResourceNotFoundException;
import com.aashna.BlogApplication.model.Category;
import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.payloads.PostDto;
import com.aashna.BlogApplication.repositories.CategoryRepo;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.repositories.UserRepo;
import com.aashna.BlogApplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private CategoryRepo categoryRepo;


    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);

        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    // UPDATE
    @Override
    @CachePut(value="PostDto", key="#postId")
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    // Delete by id
    @Override
    @CacheEvict(value="PostDto", key="#postId")
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        this.postRepo.delete(post);

    }

    // GET POST BY ID
    @Override
    @Cacheable(value="PostDto", key="#postId")
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    // getPostsByUser
    @Override
    @Cacheable(value="UserDto", key="#userId")
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    @Cacheable(value="PostDto", key="#keywords")
    public List<PostDto> searchPosts(String keywords) {

        List<Post> posts = this.postRepo.searchByTitle("%" + keywords + "%");

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    @Cacheable(value="CategoryDto", key="#categoryId")
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        List<Post> posts = this.postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }
}
