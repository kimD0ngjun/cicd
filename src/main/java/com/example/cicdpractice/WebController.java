package com.example.cicdpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Value("${server.env}")
    private String env;

    @Value("${server.address}")
    private String address;

    @Value("${server.port}")
    private String port;

    @Value("${serverName}")
    private String serverName;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("env", env);
        model.addAttribute("address", address);
        model.addAttribute("port", port);
        model.addAttribute("serverName", serverName);

        return "index";
    }

    @PostMapping("/message")
    public String message(@RequestParam("inputMessage") String inputMessage, Model model) {
        model.addAttribute("message", inputMessage);
        return "index";
    }
}
