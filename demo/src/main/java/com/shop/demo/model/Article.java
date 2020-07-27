package com.shop.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Entity(name = "ARTICLE")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    //fetch?????????????????????????????????????????????????????????
    @OneToMany(mappedBy = "article" ,cascade = CascadeType.ALL)
    private List<Comment> comments;
}
