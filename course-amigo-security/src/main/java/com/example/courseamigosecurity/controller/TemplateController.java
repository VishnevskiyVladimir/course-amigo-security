package com.example.courseamigosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vladimir Vishnevskiy
 */

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    String getLoginView() {
        return "login";
    }

}
