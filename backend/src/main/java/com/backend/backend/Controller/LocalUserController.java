package com.backend.backend.Controller;

import com.backend.backend.Service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class LocalUserController {
    @Autowired
    LocalUserService localUserService;
}
