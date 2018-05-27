package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.services.AccountService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signIn(HttpSession session, @RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        Account account;
        if ((account = accountService.signIn(email, pass)) != null) {
            session.setAttribute("account", account);
            return "forward:/index";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(HttpSession session, @RequestParam(value = "userName") String userName, @RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {

        if (accountService.signUp(userName, email, pass)) {
            session.setAttribute("account", accountService.signIn(email, pass));
            return "forward:/index";
        }
        return "redirect:/login";
    }

    @RequestMapping("/wishlist")
    public String wishList() {
        return "wishlist";
    }
}
