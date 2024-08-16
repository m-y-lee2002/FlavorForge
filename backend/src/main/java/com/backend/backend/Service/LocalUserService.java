package com.backend.backend.Service;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalUserService {

    @Autowired
    private LocalUserRepo localUserRepo;

}