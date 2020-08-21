package com.shop.demo.controllers;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.repository.CommentRepository;
import com.shop.demo.repository.UserRepository;
import com.shop.demo.service.ArticleService;
import com.shop.demo.model.dto.BoxForArticle;
import com.shop.demo.service.CommentService;
import com.shop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");

        try {
            Date date = simpleDateFormat.parse(relase);

            System.out.println("date:   " + date);
            System.out.println("date.toString():      " + date.toString());

            articleService.saveArticle(Article.builder()
                    .title(title)
                    .content(content)
                    .build());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "index";
    }

    @RequestMapping(value = "/viewArticle", method = RequestMethod.GET)
    public @ResponseBody
    BoxForArticle returnListOfAllArticle() {
        List<Article> articles = articleService.returnAllArticle();
        BoxForArticle boxForArticle = new BoxForArticle(articles, "to jest przyklad");
        return boxForArticle;
    }

    @PostMapping(value = "/viewArticle")
    public String viewArticle() {
        return "viewArticle";
    }


    @RequestMapping(value = "/allArticleByTitle", method = RequestMethod.GET)
    public @ResponseBody
    List<Article> getAllArticleByTitle() {
        return articleService.returnAllArticleByTitle("test");
    }


    //TODO get atributes from form, update the article, send the id article
    @PostMapping(value = "/createComment")
    public String createComment(@RequestParam(name = "comment-body") String commentBody, Principal principal /* get username*/ ){
        commentService.createComment(commentBody, principal);
        return "viewArticle";
    }

}
