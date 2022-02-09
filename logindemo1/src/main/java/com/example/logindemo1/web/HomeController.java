package com.example.logindemo1.web;

import com.example.logindemo1.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


/*홈페이지 접속 시 로그인상태가 아니면 홈페이지를 보여주고
로그인상태라면 로그인한 사용자의 이름을 보여줌
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = true) Member loginMember, Model model) {
        //세션에 회원 데이터가 없으면 홈으로 이동
        if (loginMember == null) {
            return "home";
        }

        //세션이 유지되면 로그인 홈으로 이동
        model.addAttribute("member", loginMember);

        return "loginHome";
    }
}
