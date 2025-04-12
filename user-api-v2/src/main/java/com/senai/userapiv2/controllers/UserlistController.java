package com.senai.userapiv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userlist")
public class UserlistController {

    @GetMapping
    public String obterUserList() {
        return "userlist";
    }
}
