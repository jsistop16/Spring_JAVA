package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//annotation
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";//hello.html을 리턴해주는것
        //resource/templates/hello.html을 찾게끔 구조돼있음
        //컨트롤러에서 문자열을 반환하면  viewResolver를 통해 화면을 찾아서 처리함
        //'resources:templates/' + {ViewName} + '.html' 로 뷰 네임 매핑
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//템플린엔진을 통해 html코드를 렌더링하는 방식이 아니라
    // http에서의 body부분에 리턴값을 넣어주겠다 라는 의미
    //데이터를 그대로 내려준다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        //이렇게 객체를 반환하면 json converter가 동작하면서 json형식으로 출력됨
        //문자열을 반환하면 html converter가 동작하면서 html이 보여짐
        //객체를 json으로 바꿔주는 라이브러리 jackson
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
