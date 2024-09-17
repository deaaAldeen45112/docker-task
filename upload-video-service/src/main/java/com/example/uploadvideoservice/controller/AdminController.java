package com.example.uploadvideoservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/auth")
public class AdminController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("upload")
    public String upload() {
        return "upload";
    }
}
