package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Book;

import java.util.List;

public interface BookService {
    List<Book> getFeatureBooks();

    Book findById(int id);
}
