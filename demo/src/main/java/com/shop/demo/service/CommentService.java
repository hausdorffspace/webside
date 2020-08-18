package com.shop.demo.service;

import com.shop.demo.model.Comment;
import com.shop.demo.repository.ArticleRepository;
import com.shop.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public void createComment(Comment comment){
        commentRepository.save(comment);
    }

}
