package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.hcmuaf.bookstore.repositories.AccountRepository;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

}
