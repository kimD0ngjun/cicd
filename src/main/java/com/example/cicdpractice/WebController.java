package com.example.cicdpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 1. 2024.10.30 오후 3시 34분 현재 동작 컨테이너명: blue
 * 2. 2024.10.30 오후 3시 40~50분 현재 동작 컨테이너명: green
 * 3. 2024.10.30 2번쨰 시점의 green 컨테이너가 동작이 중지되지 않음 어라?
 * * 한 번 컨테이너를 직접 삭제하고 해볼까
 *  * * 1시간 후에 다시 확인하니 됐네????
 * 4. 2024.10.30 오후 5시 4분 현재 동작 컨테이너명: blue
 */
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
