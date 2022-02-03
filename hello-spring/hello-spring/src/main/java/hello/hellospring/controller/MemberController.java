package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    //GetMapping은 뷰리졸버에서 html코드를 받아서 뷰템플릿엔진(thymeleaf)을 통해
    //화면 렌더링 해주는 방식
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    //PostMapping은 특정데이터를 담은 form데이터를 보내서 전달할때
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";//다시 홈화면으로 돌려보내기
    }

    @GetMapping("/members")//회원목록 버튼 눌렀을때
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        //모든 회원들(members)을 model안에 담아놓음
        return "members/memberlist";
    }
}
