package com.shop.demo.model.dto;

import com.shop.demo.model.Article;
import lombok.Data;

import java.util.List;
@Data
public class BoxForArticle {

    private List<Article> list;

    private String example;

    public BoxForArticle(List<Article> list, String example) {
        this.list = list;
        this.example = example;
    }
}
