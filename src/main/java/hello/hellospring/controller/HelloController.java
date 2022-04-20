package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    static
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "bitch";
    }

//    mvc
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String bitch, Model model){
        model.addAttribute("name", bitch);
        return "hello-template";
    }

//    api
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {

        return "your name is " +name;
    }

//    real api with json
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String bitch){
        Hello hello = new Hello();
        hello.setName(bitch);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {

            return name;
        }
        public void setName(String name) {

            this.name = name;
        }
    }
}
