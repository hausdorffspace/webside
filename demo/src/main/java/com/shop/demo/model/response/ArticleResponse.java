package com.shop.demo.model.response;

import com.shop.demo.model.Comment;
import com.shop.demo.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class ArticleResponse {

    private Long id;

    private String title;

    private String content;

    private String date;

    private String userName;

}
