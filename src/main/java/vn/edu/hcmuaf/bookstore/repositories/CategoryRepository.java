package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findById(int id);
}
