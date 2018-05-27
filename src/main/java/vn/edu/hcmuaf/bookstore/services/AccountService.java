package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Account;

public interface AccountService {

    boolean signUp(String userName, String email, String pass);

    Account signIn(String email, String pass);
}
