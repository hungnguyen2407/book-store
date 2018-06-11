package vn.edu.hcmuaf.bookstore.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.domains.Cart;
import vn.edu.hcmuaf.bookstore.domains.OrderItems;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TransactionController {

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {

        Cart cart = (Cart) session.getAttribute("cart");
        cart = cartHandler(session, cart);

        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(HttpSession session, HttpServletRequest request,
                            @RequestParam("id") int idBook,
                            @RequestParam("name") String nameBook,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("costPerItem") double costPerItem) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart = cartHandler(session, cart);

        OrderItems orderItems = new OrderItems();
        orderItems.setIdBook(idBook);
        orderItems.setNameBook(nameBook);
        orderItems.setCostPerItem(costPerItem);
        orderItems.setQuantity(quantity);
        cart.addItem(orderItems);

        session.setAttribute("cart", cart);

        return "redirect:" + request.getHeader("referer");
    }

    private Cart cartHandler(HttpSession session, Cart cart) {
        if (cart == null) {
            Account account = (Account) session.getAttribute("account");
            if (account == null)
                cart = new Cart(0, new ArrayList<>(), 0.0);
            else
                cart = new Cart(account.getId(), new ArrayList<>(), 0.0);

            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @PutMapping("/cart/update")
    public String updateCart(HttpSession session,
                             @RequestParam("index") int index,
                             @RequestParam("quantity") int quantity) {

        Cart cart = (Cart) session.getAttribute("cart");

        cart.updateItem(index, quantity);

        return "redirect:/cart";
    }

    @DeleteMapping("/cart/delete")
    public String deleteCart(HttpSession session) {
        session.setAttribute("cart", null);
        return "redirect:/cart";
    }

    @DeleteMapping("/cart/delete/item")
    public String deleteItem(HttpSession session,
                             @RequestParam("index") int index) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.rmItem(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkOut() {
        return "checkout";
    }
}
