package com.shop.demo.controllers;

import com.shop.demo.model.Comment;
import com.shop.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/getAllCommentsById/{id}")
    public @ResponseBody List<Comment> getCommentsByArticleId(@PathVariable(name = "id") Long id) {
        return commentService.getAllCommentByArticleId(id);
    }

    /*@RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
    public List<Comment> getCommentByArticleId(@RequestParam("id") Long id){
        return commentService.getAllCommentByArticleId(id);
    }*/
/*
    @GetMapping(value = "/getAllComments")
    public @ResponseBody List<Comment> getAllComments(){
        return commentService.getAllComments();
    }*/
}
