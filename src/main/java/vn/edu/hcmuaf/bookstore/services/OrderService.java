package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Cart;

public interface OrderService {

    void save(Cart cart);
}
