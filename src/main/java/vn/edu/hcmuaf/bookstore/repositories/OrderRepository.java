package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Category;

public interface OrderRepository extends CrudRepository<Category, Integer> {
}
