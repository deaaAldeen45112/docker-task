package com.example.videostreaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/auth")
public class UserPagesController {

    @GetMapping ("login")
    public String login() {
        return "login";
    }

    @GetMapping("videos")
    public String videos() {
        return "videos";
    }
}