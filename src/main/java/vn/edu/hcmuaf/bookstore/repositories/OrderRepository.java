package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
