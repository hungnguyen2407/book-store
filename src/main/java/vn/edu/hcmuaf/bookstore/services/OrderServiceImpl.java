package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.bookstore.domains.Cart;
import vn.edu.hcmuaf.bookstore.domains.Order;
import vn.edu.hcmuaf.bookstore.domains.OrderItems;
import vn.edu.hcmuaf.bookstore.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Cart cart) {
        String books = "";
        Order order = new Order();
        for (OrderItems or : cart.getListItems()) {
            books += or.getIdBook() + ":" + or.getQuantity() + " ";
            order.setBooks(books);
        }
        order.setAccount(cart.getAccount());
        double total = cart.getTotal();
        double tax = cart.getTotal() * 10 / 100;
        order.setCost(total - tax);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }
}
