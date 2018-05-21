package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.services.AccountService;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/signin")
    public String signIn(@RequestBody String requestBody) {
        return null;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        accountService.signUp(new Account());

        return "index";
    }

    @RequestMapping("/wishlist")
    public String wishList() {
        return "wishlist";
    }
}
