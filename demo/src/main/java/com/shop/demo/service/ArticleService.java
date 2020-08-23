package com.shop.demo.service;


import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void saveArticle(String content, String title, String relase){
        try {
            /*String name = SecurityContextHolder.getContext().getAuthentication().getName();  anothe way to get userName */
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");
            Date date = simpleDateFormat.parse(relase);
            articleRepository.save(Article.builder()
                    .title(title)
                    .content(content)
                    .date(date)
                    .build()
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Article> returnAllArticle(){
        return articleRepository.findAll();
    }

    public List<Article> returnAllArticleByTitle(String title){
        return articleRepository.findAllByTitle(title);
    }

    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }
}
