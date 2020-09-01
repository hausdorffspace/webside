package com.shop.demo.service;

import com.shop.demo.model.Comment;
import com.shop.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private UserService userService;

    private ArticleService articleService;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleService articleService, UserService userService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
        this.userService = userService;
    }

    public void createComment(String commentBody,String articleId){
        Comment comment = Comment.builder()
                .content(commentBody)
                .article(articleService.getArticleById(Long.decode(articleId)+1L))
                .user(userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()))
                .build();
        commentRepository.save(comment);
    }

    public List<Comment> getAllCommentByArticleId(Long id){
        return commentRepository.getAllCommentByArticleId(id);
    }

    public List<Comment> getAllComennts(){
        return commentRepository.getAllComents();
    }
}
