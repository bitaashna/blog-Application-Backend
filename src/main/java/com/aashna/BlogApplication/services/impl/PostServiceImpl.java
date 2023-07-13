package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public String createPost(Post post) {
        //data via repository layer saved into db
        postRepo.save(post);
        return "Success";
    }

    @Override
    public String updatePost(Post post) {
        postRepo.save(post);
        return "Success";
    }

    @Override
    public Post getPostById(Integer postId) {
        return postRepo.findById(postId).get();
    }

    @Override
    public String deletePost(Integer postId) {
        postRepo.deleteById(postId);
        return "Success";
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }
}
