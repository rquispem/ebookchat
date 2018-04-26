package com.app.rquispe.ebook.authentication.api;

import com.app.rquispe.ebook.authentication.domain.model.User;
import com.app.rquispe.ebook.authentication.domain.service.UserService;
import com.app.rquispe.ebook.authentication.validator.NewUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewUserValidator newUserValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(newUserValidator);
    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/new-account")
    public String newAccount(Model model) {
        model.addAttribute("user", new User());
        return "new-account";
    }
    @RequestMapping(path = "/new-account", method = RequestMethod.POST)
    public String createAccount(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-account";
        }
        userService.createUser(user);
        return "redirect:/";
    }
}
