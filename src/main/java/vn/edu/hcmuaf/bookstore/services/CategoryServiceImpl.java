package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.hcmuaf.bookstore.repositories.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
}
