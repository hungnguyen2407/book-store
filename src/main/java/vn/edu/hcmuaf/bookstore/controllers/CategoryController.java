package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @GetMapping(value = "/category", params = "category")
    public String categorySelector() {
        return "category";
    }
}
