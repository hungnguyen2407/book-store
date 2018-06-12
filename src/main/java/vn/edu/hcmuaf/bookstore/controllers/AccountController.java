package vn.edu.hcmuaf.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.services.AccountService;
import vn.edu.hcmuaf.bookstore.services.Ultilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/info")
    public String info(HttpSession session, Model model, @CookieValue(value = "email", defaultValue = "") String email, @CookieValue(value = "pass", defaultValue = "") String pass) {
        Object account;
        if ((account = session.getAttribute("account")) != null) {
            if (account instanceof Account) {
                model.addAttribute("settingName", "settings-general");
                return "account";
            }
        } else if ((account = accountService.signInWithEncryptedPass(email, pass)) != null) {
            session.setAttribute("account", account);
            return "redirect:/index";
        }
        return "redirect:/login";
    }

    @PostMapping("/account/signin")
    public String signIn(HttpSession session, @RequestParam(value = "email") String email,
                         @RequestParam(value = "pass") String pass,
                         @RequestParam(value = "keepSignIn", defaultValue = "false", required = false) boolean keepSignIn,
                         HttpServletResponse response) {
        Account account;

        if ((account = accountService.signIn(email, pass)) != null) {

            if (keepSignIn) {
                Cookie cookie = new Cookie("email", email);
                cookie.setPath("/bookstore");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);

                cookie = new Cookie("pass", Ultilities.encryptText(pass));
                cookie.setPath("/bookstore");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }

            session.setAttribute("cart", null);
            session.setAttribute("account", account);
            return "redirect:/index";
        }
        return "redirect:/login";
    }

    @GetMapping("/account/signout")
    public String signOut(HttpSession session, HttpServletResponse response) {
        session.setAttribute("account", null);
        session.removeAttribute("account");
        Cookie cookie = new Cookie("email", null);
        cookie.setPath("/bookstore");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cookie = new Cookie("pass", null);
        cookie.setPath("/bookstore");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cartHandler(session);
        return "redirect:/index";
    }

    private void cartHandler(HttpSession session) {
        session.setAttribute("cart", null);

    }

    @PostMapping("/account/signup")
    public String signUp(HttpSession session, @RequestParam(value = "userName") String userName,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "pass") String pass) {
        accountService.signUp(userName, email, pass);
        Account account = accountService.signIn(email, pass);
        if (account != null) {
            session.setAttribute("account", account);
            return "redirect:/index";
        }
        return "redirect:/login";
    }

    @GetMapping("/account/wishlist")
    public String wishList(HttpSession session) {
        Object account;
        if ((account = session.getAttribute("account")) != null)
            if (account instanceof Account)
                return "wishlist";
        return "redirect:/login";

    }

    @GetMapping("/account/settings/general")
    public String settingGeneral(HttpSession session, Model model) {
        Object account;
        if ((account = session.getAttribute("account")) != null)
            if (account instanceof Account) {
                model.addAttribute("settingName", "settings-general");
                return "account";
            }
        return "redirect:/login";
    }

    @GetMapping("/account/settings/privacy")
    public String settingPrivacy(HttpSession session, Model model) {
        Object account;
        if ((account = session.getAttribute("account")) != null)
            if (account instanceof Account) {
                model.addAttribute("settingName", "settings-privacy");
                return "account";
            }
        return "redirect:/login";
    }

    @GetMapping("/account/settings/sercure")
    public String settingSecure(HttpSession session, Model model) {
        Object account;
        if ((account = session.getAttribute("account")) != null)
            if (account instanceof Account) {
                model.addAttribute("settingName", "settings-secure");
                return "account";
            }
        return "redirect:/login";
    }

    @GetMapping("/account/settings/activity")
    public String settingActivity(HttpSession session, Model model) {
        Object account;
        if ((account = session.getAttribute("account")) != null)
            if (account instanceof Account) {
                model.addAttribute("settingName", "settings-activity");
                return "account";
            }
        return "redirect:/login";
    }


}
