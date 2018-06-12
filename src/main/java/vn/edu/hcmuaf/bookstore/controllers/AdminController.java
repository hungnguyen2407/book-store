package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/signin")
    public String login(Model model) {
        return "admin-signin";
    }

}
