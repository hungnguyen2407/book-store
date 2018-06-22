package vn.edu.hcmuaf.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.hcmuaf.bookstore.domains.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Admin findByAdminId(String adminId);
}
