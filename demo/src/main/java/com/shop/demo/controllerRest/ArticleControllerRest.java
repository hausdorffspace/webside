package com.shop.demo.controllerRest;

import com.shop.demo.model.Article;
import com.shop.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleControllerRest {

    private ArticleService articleService;

    @Autowired
    public ArticleControllerRest(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping()
    public Article addArticle(@RequestBody  Article article){
        articleService.addArticle(article);
        return article;
    }

}
