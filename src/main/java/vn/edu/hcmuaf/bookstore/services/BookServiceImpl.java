package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.bookstore.domains.Book;
import vn.edu.hcmuaf.bookstore.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getFeatureBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Book> findByCategory(int id) {
        List<Book> list = new ArrayList<>();
        StringTokenizer st;
        for (Book book : bookRepository.findAll()) {
            st = new StringTokenizer(book.getCategories(), " ");
            while (st.hasMoreElements()) {
                if (st.nextToken().equals(id + ""))
                    list.add(book);
            }
        }
        return list;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }
}
