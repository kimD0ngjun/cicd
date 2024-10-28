package com.example.cicdpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Value("${custom.setting}")
    private String setting;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/setting")
    public String setting(Model model) {
        model.addAttribute("setting", setting);
        return "index";
    }

    @PostMapping("/message")
    public String message(@RequestParam("inputMessage") String inputMessage, Model model) {
        model.addAttribute("message", inputMessage);
        return "index";
    }
}
