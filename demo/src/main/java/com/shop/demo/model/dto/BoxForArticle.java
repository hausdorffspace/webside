package com.shop.demo.model.dto;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import com.shop.demo.model.response.ArticleResponse;
import com.shop.demo.model.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class BoxForArticle {

    private List<ArticleResponse> articleList;

    private List<CommentResponse> commentList;
}
