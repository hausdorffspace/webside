package com.shop.demo.service;


import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.model.response.ArticleResponse;
import com.shop.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    private UserService userService;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    public void saveArticle(String content, String title){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .date(formatter.format(date))
                .user(userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()))
                .build()
        );
    }

    public List<ArticleResponse> returnAllArticle(){
        System.out.println(articleRepository.findAll().get(1).getUser());
        return articleRepository.findAll().stream()
                .map(article -> ArticleResponse.builder()
                        .content(article.getContent())
                        .date(article.getDate())
                        .title(article.getTitle())
                        .userName(article.getUser().getName())
                        .id(article.getId())
                        .build())
                .collect(Collectors.toList());
    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public List<Article> returnAllArticleByTitle(String title){
        return articleRepository.findAllByTitle(title);
    }

    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }



    //////////////////////////////
    ///Methods for REST //////////
    //////////////////////////////


    public void addArticle(Article article){
        articleRepository.save(article);
    }

}
