package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.Comment;
import com.aashna.BlogApplication.model.Post;
import com.aashna.BlogApplication.payloads.CommentDto;
import com.aashna.BlogApplication.repositories.CommentRepo;
import com.aashna.BlogApplication.repositories.PostRepo;
import com.aashna.BlogApplication.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

        Post post = postRepo.findById(postId).get();

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        // TODO Auto-generated method stub

        Comment com = this.commentRepo.findById(commentId).get();
        this.commentRepo.delete(com);

    }

}
