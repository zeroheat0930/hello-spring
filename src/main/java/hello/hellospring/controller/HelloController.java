package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //hello라는 url 주소받아왓음 외부 서버에서 톰켓한테 임무줌
    public String Hello(Model model){
        model.addAttribute("data", "hello!!");
    return "hello"; // 리소스에 템플릿 hello.html을 찾아서 랜더링해라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return  "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

// alt+ insert 윈도우 , 커맨드+n 맥북
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
