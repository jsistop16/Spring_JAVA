package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {//CrudRepository의 제네릭은 관리대상entity(Article)과 그 관리대상의 대표값(id)의 타입(Long)

}
