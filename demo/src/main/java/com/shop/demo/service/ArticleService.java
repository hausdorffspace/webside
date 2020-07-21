package com.shop.demo.service;


import com.shop.demo.model.Article;
import com.shop.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> returnAllArticle(){
        return articleRepository.findAll();
    }
}
