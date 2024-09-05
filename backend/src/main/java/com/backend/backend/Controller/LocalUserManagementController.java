package com.backend.backend.Controller;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Service.LocalUserManagementService;
import com.backend.backend.Service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class LocalUserManagementController {
    @Autowired
    LocalUserManagementService localUserManagementService;

    @GetMapping("/api/account/login/{email}/{password}")
    public ResponseEntity<LocalUser> verifyLogin(@PathVariable("email") String targetEmail, @PathVariable("password") String targetPassword ){
        try{
            String hashedPassword = DigestUtils.sha1Hex(targetPassword);
            System.out.println(hashedPassword);
            return ResponseEntity.ok(localUserManagementService.verifyAccount(targetEmail, hashedPassword));
        }catch(RuntimeException e){
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/api/account/register")
    public ResponseEntity<String> registerUser(@RequestBody LocalUser targetUser){
        try{
            targetUser.setPassword(DigestUtils.sha1Hex(targetUser.getPassword()));
//            targetUser.setPassword("0");
            LocalUser usernameExists = localUserManagementService.getLocalUserByUsername(targetUser.getUsername());
            LocalUser emailExists = localUserManagementService.getLocalUserByEmail(targetUser.getEmail());
            if(emailExists != null){
                return ResponseEntity.ok("Email in use.");
            }else if(usernameExists != null){
                return ResponseEntity.ok("Username in use.");
            }else{
                LocalUser savedUser = localUserManagementService.saveLocalUser(targetUser);
                if(savedUser!= null){
                    return ResponseEntity.ok("Successful register.");
                }
                return ResponseEntity.ok("Unexpected result from register.");

            }
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}