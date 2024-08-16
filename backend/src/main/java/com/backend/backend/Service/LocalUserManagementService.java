package com.backend.backend.Service;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalUserManagementService {

    @Autowired
    private LocalUserRepo localUserRepo;

    public Boolean verifyAccount(String email, String password) {
        LocalUser user = localUserRepo.findLocalUserByEmail(email);
        if (user != null) {
            // Assuming passwords are stored as hashed, compare the hashed password
            return user.getPassword().equals(password); // Adjust this if you are using hashing
        }
        return false; // Return false if the user is not found
    }
}