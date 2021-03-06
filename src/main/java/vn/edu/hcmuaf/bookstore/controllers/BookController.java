package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.hcmuaf.bookstore.services.BookService;
import vn.edu.hcmuaf.bookstore.services.CategoryService;

import javax.websocket.server.PathParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/book")
    public String getBook(@PathParam("id") int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-details";
    }


}
