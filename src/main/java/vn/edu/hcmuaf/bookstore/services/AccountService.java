package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Account;

public interface AccountService {

    boolean signUp(Account newAccount);
}
