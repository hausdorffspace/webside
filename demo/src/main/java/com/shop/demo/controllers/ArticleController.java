package com.shop.demo.controllers;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.repository.CommentRepository;
import com.shop.demo.repository.UserRepository;
import com.shop.demo.service.ArticleService;
import com.shop.demo.model.dto.BoxForArticle;
import com.shop.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserRepository userRepository;

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


    //dziala
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
    public String createComment(){
        Comment comment = Comment.builder()
                .content("this is a superb article!!!")
                .user(userRepository.findByLogin("test").get())
                .build();
        commentService.createComment(comment);


        Long id = new Long(1L);
        Article retrivedArticle = articleService.getArticleById(id);

        //correct, this could be better, CLEAN CODE
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        retrivedArticle.setComments(comments);

        return "viewArticle";
    }
}
