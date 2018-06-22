package vn.edu.hcmuaf.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.bookstore.domains.Admin;
import vn.edu.hcmuaf.bookstore.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin signIn(String adminId, String pass) {
        Admin admin = adminRepository.findByAdminId(adminId);

        if (admin != null)
            if (admin.getPass().equals(Ultilities.encryptText(pass)))
                return admin;

        return null;

    }
}
