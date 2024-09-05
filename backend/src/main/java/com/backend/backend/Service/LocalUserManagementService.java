package com.backend.backend.Service;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class LocalUserManagementService {

    @Autowired
    private LocalUserRepo localUserRepo;

    public LocalUser verifyAccount(String email, String password) {
        LocalUser user = localUserRepo.findLocalUserByEmail(email);
        if (user != null) {
            // Assuming passwords are stored as hashed, compare the hashed password
            if(user.getPassword().equals(password)){
                return user;// Adjust this if you are using hashing
            }
        }
        return null; // Return false if the user is not found
    }
    public LocalUser saveLocalUser(LocalUser targetUser){
        try {
            return localUserRepo.save(targetUser);
        } catch (DataIntegrityViolationException e) {
            // Handle data integrity violations (e.g., unique constraint violations)
            throw new RuntimeException("Failed to save user due to data integrity violation: " + e.getMessage());
        } catch (Exception e) {
            // Handle other unexpected exceptions
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }

    }
    public LocalUser getLocalUserByEmail(String targetEmail){
        try{
            return localUserRepo.findLocalUserByEmail(targetEmail);
        }catch(Exception e){
            throw new RuntimeException("Failed to get user by email: " + e.getMessage());
        }
    }

    public LocalUser getLocalUserByUsername(String targetUsername){
        try{
            return localUserRepo.findLocalUserByUsername(targetUsername);
        }catch(Exception e){
            throw new RuntimeException("Failed to get user by username: " + e.getMessage());
        }
    }
}