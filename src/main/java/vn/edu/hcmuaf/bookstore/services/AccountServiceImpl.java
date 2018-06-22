package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.bookstore.domains.Account;
import vn.edu.hcmuaf.bookstore.repositories.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account signUp(String userName, String email, String pass) {
        return accountRepository.save(new Account(Ultilities.encryptText(pass), email, userName));
    }

    @Override
    public Account signIn(String email, String pass) {
        Account account = accountRepository.findByEmail(email);
        if (account != null)
            if (account.getPass().equals(Ultilities.encryptText(pass)))
                return account;
        return null;
    }

    @Override
    public Account signInWithEncryptedPass(String email, String pass) {
        Account account;
        if ((account = accountRepository.findByEmail(email)) != null)
            if (account.getPass().equals(pass))
                return account;
        return null;
    }

}
