package com.app.rquispe.ebook.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }
}
