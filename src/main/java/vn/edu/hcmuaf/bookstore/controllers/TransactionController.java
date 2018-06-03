package vn.edu.hcmuaf.bookstore.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.domains.Cart;
import vn.edu.hcmuaf.bookstore.domains.OrderItems;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller
public class TransactionController {

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addToCart(@PathParam("id") int id, HttpServletRequest request, Model model, @Valid OrderItems orderItems) {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            Account account = (Account) session.getAttribute("account");
            if (account == null)
                cart = new Cart(0, new ArrayList<>());
            else
                cart = new Cart(account.getId(), new ArrayList<>());
        }
        cart.addOrderItems(orderItems);
        session.setAttribute("cart", cart);

        return "redirect:" + request.getHeader("referer");

    }

    @GetMapping("/checkout")
    public String checkOut() {
        return "checkout";
    }
}
