package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.hcmuaf.bookstore.repositories.BookRepository;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
}
