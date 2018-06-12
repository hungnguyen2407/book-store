package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.domains.OrderItems;
import vn.edu.hcmuaf.bookstore.services.BookService;
import vn.edu.hcmuaf.bookstore.services.CategoryService;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("books", bookService.getFeatureBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("orderItems", new OrderItems());
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
}
