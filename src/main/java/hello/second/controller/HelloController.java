package hello.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}