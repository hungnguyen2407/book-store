package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.hcmuaf.bookstore.services.BookService;
import vn.edu.hcmuaf.bookstore.services.CategoryService;

import javax.websocket.server.PathParam;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/category")
    public String categorySelector(@PathParam(value = "id") int id, Model model) {
        model.addAttribute("books", bookService.findByCategory(id));
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category";
    }
}
