package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")//접속할 url 주소 /hi를 찍으면 greetings.mustache를 찾아서 반환
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "jun");//
        return "greetings"; // templates/greetings.mustache를 알아서 찾아서 -> 브라우저로 전송 (return값으로는 mustache파일명이 들어감)
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "jun");
        return "goodbye";
    }
}
