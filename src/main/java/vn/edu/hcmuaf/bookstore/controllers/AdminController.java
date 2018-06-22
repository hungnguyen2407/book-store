package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.bookstore.domains.*;
import vn.edu.hcmuaf.bookstore.services.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = {"/admin/home", "/admin"})
    public String home(Model model, HttpSession session) {

        Admin admin = (Admin) session.getAttribute("admin");

        if (!isSignIn(session))
            return "redirect:/admin/signin";

        model.addAttribute("admin", admin);

        return "admin-home";
    }

    @GetMapping("/admin/signin")
    public String signInView() {


        return "admin-signin";
    }

    @PostMapping("/admin/signin")
    public String signIn(Model model, HttpSession session,
                         @RequestParam("adminId") String adminId,
                         @RequestParam("pass") String pass) {

        Admin admin = adminService.signIn(adminId, pass);

        model.addAttribute("admin", admin);

        session.setAttribute("admin", admin);

        return "redirect:/admin";
    }

    @GetMapping("/admin/manager/account")
    public String managerAccount(HttpSession session, Model model) {

        if (isSignIn(session)) {
            ArrayList<Account> listAcc = (ArrayList<Account>) accountService.getAll();
            model.addAttribute("listAcc", listAcc);

            return "admin-manager-account";

        }

        return "error";
    }

    @GetMapping("/admin/manager/account/edt/{id}")
    public String viewAccount(HttpSession session, Model model, @PathVariable("id") int id) {
        if (isSignIn(session)) {
            return "admin-manager-account-detail";

        }
        return "error";
    }

    @PostMapping("/admin/manager/account/dis")
    public String disableAccount(HttpSession session, Model model,
                                 @RequestParam("index") int index) {
        if (isSignIn(session)) {

        }

        return "error";
    }

    @DeleteMapping("/admin/manager/account/rm")
    public String rmAccount(HttpSession session, Model model,
                            @RequestParam("index") int index) {
        if (isSignIn(session)) {

        }

        return "error";
    }

    @PostMapping("/admin/manager/account")
    public String editAccount(HttpSession session, Model model,
                              @RequestParam("id") int id,
                              @RequestParam("email") String email,
                              @RequestParam("pass") String pass) {
        if (isSignIn(session)) {

        }

        return "error";
    }

    @GetMapping("/admin/manager/product")
    public String managerProduct(HttpSession session, Model model) {
        if (isSignIn(session)) {
            ArrayList<Book> listBook = (ArrayList<Book>) bookService.getAll();

            model.addAttribute("listBook", listBook);

            return "admin-manager-product";
        }

        return "error";
    }


    @GetMapping("/admin/manager/category")
    public String managerCategory(HttpSession session, Model model) {
        if (isSignIn(session)) {
            ArrayList<Category> listCat = (ArrayList<Category>) categoryService.getAllCategories();

            model.addAttribute("listCat", listCat);
            return "admin-manager-category";
        }

        return "error";
    }

    @GetMapping("/admin/manager/order")
    public String managerOrder(HttpSession session, Model model) {
        if (isSignIn(session)) {
            ArrayList<Order> listOrder = (ArrayList<Order>) orderService.getAll();

            model.addAttribute("listOrder", listOrder);
            return "admin-manager-order";
        }
        return "error";
    }

    private boolean isSignIn(HttpSession session) {

        Admin admin = (Admin) session.getAttribute("admin");

        return admin != null;
    }

}
