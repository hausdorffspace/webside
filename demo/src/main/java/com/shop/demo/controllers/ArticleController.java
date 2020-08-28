package com.shop.demo.controllers;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.service.ArticleService;
import com.shop.demo.model.dto.BoxForArticle;
import com.shop.demo.service.CommentService;
import com.shop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("/addArticle")
    public String addArticle() {
        return "addArticle";
    }

    @PostMapping("/addArticle")
    public String addArticle(@RequestParam(name = "title") String title,
                             @RequestParam(name = "content") String content,
                             @RequestParam(name = "relase") String relase
    ) {
        articleService.saveArticle(content,title,relase);
        return "index";
    }

    @GetMapping(value = "/viewArticle")
    public @ResponseBody
    BoxForArticle returnListOfAllArticle() {
        return new BoxForArticle(articleService.returnAllArticle(), "to jest przyklad");
    }

    @PostMapping(value = "/viewArticle")
    public String viewArticle() {
        return "viewArticle";
    }

    @GetMapping(value = "/allArticleByTitle")
    public @ResponseBody
    List<Article> getAllArticleByTitle() {
        return articleService.returnAllArticleByTitle("test");
    }

}
