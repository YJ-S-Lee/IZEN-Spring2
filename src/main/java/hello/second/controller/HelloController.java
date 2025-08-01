package hello.second.controller;

import hello.second.domain.Mvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hellow")
    public String hellow(Model model) {
        model.addAttribute("data", "이유진");
        return "hellow";
    }

    //http://localhost:8080/mvc?name=이유진&age=10000
    @GetMapping("/mvc")
    public String mvc(@RequestParam("name") String name, @RequestParam("age") String age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "mvc";
    }

    //localhost:8080/api?name=가나다&age=123
    @GetMapping("/api")
    @ResponseBody
    public String api(@RequestParam("name") String name, @RequestParam("age") String age) {
        return name + "님 환영합니다. " + name + "님의 나이는 " + age + "입니다.";
    }

    //localhost:8080/mvcapi?name=라마바&age=456
    @GetMapping("/mvcapi")
    @ResponseBody
    public Mvc mvcapi(@RequestParam("name") String name, @RequestParam("age") String age) {
        Mvc mvc = new Mvc();
        mvc.setName(name);
        mvc.setName(age);
        return mvc;
    }
}