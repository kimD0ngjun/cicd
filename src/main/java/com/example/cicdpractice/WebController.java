package com.example.cicdpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/message")
    public String message(@RequestParam("inputMessage") String inputMessage, Model model) {
        model.addAttribute("message", inputMessage);
        return "index";
    }
}
