package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        //@RequestParam은 url주소에서 ?로 데이터값 직접 전달(key값:name)
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody//body부에 데이터(매개변수 name)를 직접 넣어줌
    //html 소스보기를 눌러보면 html태그가 없이 name값에 해당하는 데이터만 바로 있음
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }

    //API방식(객체를 반환하는 방식)
    //html소스보기에서 json형식으로 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//객체 반환
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
