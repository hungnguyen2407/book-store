package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
