package com.example.demo.service;

import com.example.demo.domain.Admin;
import com.example.demo.utility.Utility;
import com.example.demo.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.utility.Constants.ADMIN_EXIST;

@Repository
@RequiredArgsConstructor
public class AdminService {

    private final Utility utility;
    private final AdminRepository adminRepository;

    public List<Admin> listAll() {

        return adminRepository.findAll();
    }

    public Admin save(Admin admin) {

        String emailValidation = utility.isValidEmail(admin.getEmail());
        String passwordValidation = utility.isValidPassword(admin.getPassword());
        if(emailValidation.length() == 0 && passwordValidation.length() == 0)  {

            Admin existAdmin = adminRepository.findByEmail(admin.getEmail());
            if(existAdmin == null) {

                return adminRepository.save(admin);
            }
            else {

                throw new RuntimeException(ADMIN_EXIST);
            }
        }
        else if(emailValidation.length() != 0){

            throw new RuntimeException(emailValidation);
        }
        else {

            throw new RuntimeException(passwordValidation);
        }
    }

    public void delete(int id) {

        adminRepository.delete(utility.findAdminOrThrowNotFound(id,adminRepository));
    }
}
