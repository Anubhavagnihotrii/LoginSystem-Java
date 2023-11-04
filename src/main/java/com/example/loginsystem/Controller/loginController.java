package com.example.loginsystem.Controller;

import com.example.loginsystem.Entity.User;
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
public class loginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        log.info("inside show get method html temp for login");
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        if (userService.authenticateUser(user.getEmail(), user.getPassword())) {
            // User authentication successful
            return "redirect:/dashboard"; // Redirect to the dashboard page on successful login
        } else {
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        // Logic for displaying the dashboard page
        return "dashboard"; // Replace with the appropriate view for the dashboard
    }
}
