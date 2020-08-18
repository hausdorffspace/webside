package com.shop.demo.model.dto;

import com.shop.demo.model.Article;

import java.util.List;

public class BoxForArticle {
    private List<Article> list;

    private String example;

    public BoxForArticle(List<Article> list, String example) {
        this.list = list;
        this.example = example;
    }

    public List<Article> getList() {
        return list;
    }
    public void setList(List<Article> list) {
        this.list = list;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
