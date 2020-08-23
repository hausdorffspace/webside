package com.shop.demo.repository;

import com.shop.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //SET nativQuery = true because jpql doesn't know what is "_"
    @Query(value = "SELECT * FROM comment AS c WHERE c.article_id=:articleId" , nativeQuery = true)
    List<Comment> getAllCommentByArticleId(@Param("articleId") Long articleId);
}

