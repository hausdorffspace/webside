package com.shop.demo.model.dto;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import lombok.Data;

import java.util.List;
@Data
public class BoxForArticle {

    private List<Article> articleList;

    private List<Comment> commentList;

    public BoxForArticle(List<Article> articleList, List<Comment> commentList) {
        this.articleList = articleList;
        this.commentList = commentList;
    }
}
