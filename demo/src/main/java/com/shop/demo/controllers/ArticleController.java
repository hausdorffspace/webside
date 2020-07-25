package com.shop.demo.controllers;

import com.shop.demo.model.Article;
import com.shop.demo.repository.UserRepository;
import com.shop.demo.service.ArticleService;
import com.shop.demo.utils.BoxForArticle;
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
    public @ResponseBody BoxForArticle returnListOfAllArticle(){
        List<Article> articles = articleService.returnAllArticle();
        BoxForArticle boxForArticle = new BoxForArticle(articles,"to jest przyklad");
        return boxForArticle;
    }

    @PostMapping(value = "/viewArticle")
    public String viewArticle(){
        return "viewArticle";
    }



}
