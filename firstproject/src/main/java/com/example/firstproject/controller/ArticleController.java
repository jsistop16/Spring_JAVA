package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j//Simple Logging Facade for Java 로깅으로 남기기위한 annotation
public class ArticleController {

    @Autowired//스프링부트가 미리 생성해놓은 객체 사용할수있음(자동 연결)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";//뷰페이지 연결
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString()); -> 로깅기능으로 대체
        log.info(form.toString());

        //1. DTO를 변환
        Article article = form.toEntity();
        //System.out.println(article.toString()); -> 로깅기능으로 대체
        log.info(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString()); -> 로깅기능으로 대체
        log.info(saved.toString());
        return "";
    }
}
