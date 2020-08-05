package com.shop.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Entity(name = "ARTICLE")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    private String title;

    @Column(length = 1000)
    private String content;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "relase_date")
    private Date date;

    //finish
    @ManyToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //finish
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "comments",
            referencedColumnName = "article_id")
    private List<Comment> comments;
}
