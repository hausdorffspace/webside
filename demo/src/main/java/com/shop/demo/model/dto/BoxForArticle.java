package com.shop.demo.model.dto;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class BoxForArticle {

    private List<Article> articleList;

    private List<Comment> commentList;
}
