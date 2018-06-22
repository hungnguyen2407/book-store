package vn.edu.hcmuaf.bookstore.services;

import vn.edu.hcmuaf.bookstore.domains.Admin;

public interface AdminService {
    Admin signIn(String adminId, String pass);

}
