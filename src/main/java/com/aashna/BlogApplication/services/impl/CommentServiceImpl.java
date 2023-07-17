package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.exceptions.ResourceNotFoundException;
import com.aashna.BlogApplication.model.Comment;
import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.payloads.CommentDto;
import com.aashna.BlogApplication.repositories.CommentRepo;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));


        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    @CacheEvict(value="CommentDto", key="#commentId")
    public void deleteComment(Integer commentId) {
        // TODO Auto-generated method stub

        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment id", commentId));

        this.commentRepo.delete(com);

    }

}
