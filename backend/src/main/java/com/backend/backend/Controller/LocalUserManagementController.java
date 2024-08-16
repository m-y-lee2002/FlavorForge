package com.backend.backend.Controller;

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
    public Boolean verifyLogin(@PathVariable("email") String targetEmail, @PathVariable("password") String targetPassword ){
        try{
            String hashedPassword = DigestUtils.sha1Hex(targetPassword);
            System.out.println(hashedPassword);
            return localUserManagementService.verifyAccount(targetEmail, hashedPassword);
        }catch(RuntimeException e){
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            return false;
        }
    }
}
