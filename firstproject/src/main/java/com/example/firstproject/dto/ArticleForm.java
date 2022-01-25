package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString//생성자와 overriding을 lombok을 통해 대체(리팩토링)(주석처리 된 부분 불필요)
public class ArticleForm {

    private String title;
    private String content;

//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity(){//return 타입:Article
        return new Article(null, title, content);
    }
}
