package com.example.loginsystem.Controller;

import com.example.loginsystem.Entity.User;
import com.example.loginsystem.Repository.UserRepository;
import com.example.loginsystem.Service.Interface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/register")
    public String showRegistration(Model model) {
        log.info("inside show, get method html temp for registration");
        model.addAttribute("useratt", new User());
        return "register";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("useratt") User user,Model model) {
        log.info("inside save method");
        if(userRepository.existsByEmail(user.getEmail()))
        {
            model.addAttribute("emailError","Email already exists");
            return "register";
        }
        else
        {
            userService.add(user);
            return "redirect:/login";
        }
    }
}
