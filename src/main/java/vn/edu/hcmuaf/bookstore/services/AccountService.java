package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Account;

public interface AccountService {

    Account signUp(String userName, String email, String pass);

    Account signIn(String email, String pass);

    Account signInWithEncryptedPass(String email, String pass);
}
