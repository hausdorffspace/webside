package com.shop.demo.controllers;

import com.shop.demo.model.Article;
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

    @PostMapping("/addArticle") // /addArticle?title=dupa&content=request size is limited to 2kb in most browsers
    public String addArticle(
            @RequestParam(name = "content") String content,
            @RequestParam(name = "title") String title
    ) {
        articleService.saveArticle(content, title);
        return "index";
    }

    /*@PostMapping("/addArticle") // /addArticle?title=dupa&content=request size is limited to 2kb in most browsers
    public String addArticle(
            @RequestBody Article article
    ) {
        articleService.saveArticle(content, title);
        return "index";
    }*/

    @GetMapping(value = "/viewArticle")
    public @ResponseBody
    BoxForArticle returnListOfAllArticle() {
        return new BoxForArticle(articleService.returnAllArticle(), commentService.getAllComennts());
    }

    @PostMapping(value = "/viewArticle")
    public String viewArticle() {
        return "viewArticle";
    }


    //getAllArticleByTitle
    @ResponseBody
    @GetMapping(value = "/articles")
    public List<Article> getAllArticleByTitle() {
        return articleService.returnAllArticleByTitle("test");
    }

}