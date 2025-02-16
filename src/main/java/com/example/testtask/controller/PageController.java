package com.example.testtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/auth/sign-up")
    public String signUpPage() {
        return "sign_up";
    }

    @GetMapping("/auth/sign-in")
    public String signInPage() {
        return "sign_in";
    }

    @GetMapping("/home/**")
    public String homePage() {
        return "home";
    }
}
