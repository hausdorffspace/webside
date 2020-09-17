package com.shop.demo.model.response;

import com.shop.demo.model.Article;
import com.shop.demo.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Builder
@Getter
public class CommentResponse {

    private Long id;

    private String content;

    private String userName;

    private Long articleId;

}
