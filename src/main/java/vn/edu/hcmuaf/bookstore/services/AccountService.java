package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account signUp(String userName, String email, String pass);

    Account signIn(String email, String pass);

    Account signInWithEncryptedPass(String email, String pass);
}
