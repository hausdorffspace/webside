package com.shop.demo.controllers;

import com.shop.demo.model.Comment;
import com.shop.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/createComment")
    public String createComment(@RequestParam(name = "comment-body") String commentBody, @RequestParam(name = "articleId") String articleId) {
        commentService.createComment(commentBody, articleId);
        return "viewArticle";
    }

    //TODO
    @GetMapping(value = "/getAllComments/{id}")
    public List<Comment> getCommentsByArticleId(@PathVariable(name = "id") Long id) {
        return commentService.getAllComment(id);
    }
}
