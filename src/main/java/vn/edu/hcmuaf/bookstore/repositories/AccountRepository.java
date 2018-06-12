package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByEmail(String email);
}
