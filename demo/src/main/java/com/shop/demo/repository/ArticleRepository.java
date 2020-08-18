package com.shop.demo.repository;

import com.shop.demo.model.Article;
import com.shop.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT a FROM ARTICLE a WHERE a.title=:title")
    List<Article> findAllByTitle(@Param("title") String title);

    @Query("SELECT a FROM ARTICLE a WHERE a.id=:id")
    Article getArticleById(@Param("id") Long id);

    
    @Param("UPDATE a ARTICLE SET")
    void updateCommentById(Long id, Comment comment);
}
