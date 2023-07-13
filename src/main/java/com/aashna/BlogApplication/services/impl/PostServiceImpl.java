package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.repositories.UserRepo;
import com.aashna.BlogApplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post createPost(Post post, Integer userId) {
        post.setAddedDate(new Date());
        //post.setUser(userRepo.findById(userId));
        //data via repository layer saved into db

        return postRepo.save(post);
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
    public List<Post> getPostByUser(Integer userId) {
        List<Post> posts= postRepo.findByUser(userId);
        return posts;
    }

    @Override
    public List<Post> searchPosts(String keywords) {
        List<Post> posts= postRepo.searchByTitle("%"+keywords+"%");
        return posts;
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
