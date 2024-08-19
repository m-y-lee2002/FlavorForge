package com.backend.backend.Repository;

import com.backend.backend.Entity.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalUserRepo extends JpaRepository<LocalUser, Long> {
    LocalUser findLocalUserByEmail(String email);
}