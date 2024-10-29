package com.example.cicdpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Value("${server.env}")
    private String env;

//    @Value("${server.address}")
//    private String address;

    @Value("${server.port}")
    private String port;

    @Value("${serverName}")
    private String serverName;

    @Value("${common.message}")
    private String commonMessage;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("commonMessage", commonMessage);
//        model.addAttribute("address", address);
        model.addAttribute("port", port);
        model.addAttribute("serverName", serverName);

        return "index";
    }

    @GetMapping("/env")
    public ResponseEntity<?> env() {
        return ResponseEntity.ok(env);
    }

    @PostMapping("/")
    public String message(@RequestParam("inputMessage") String inputMessage, Model model) {
        model.addAttribute("commonMessage", commonMessage);
        model.addAttribute("port", port);
        model.addAttribute("serverName", serverName);
        model.addAttribute("message", inputMessage);

        return "index";
    }
}
