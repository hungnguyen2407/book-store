package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Cart;
import vn.edu.hcmuaf.bookstore.domains.Order;

import java.util.List;

public interface OrderService {

    void save(Cart cart);

    List<Order> getAll();
}
