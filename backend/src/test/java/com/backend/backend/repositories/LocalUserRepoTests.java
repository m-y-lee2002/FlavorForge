package com.backend.backend.repositories;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class LocalUserRepoTests {
    @Autowired
    private LocalUserRepo localUserRepo;
    private static LocalUser testUser;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeAll
    public static void setupTestDummies(){
        testUser = setupTestUer();
    }

    public static LocalUser setupTestUer(){
        return new LocalUser("TestUser@gmail.com", "TestUser1", "12345");
    }

    @Test
    public void testFindLocalUserByEmail(){
        localUserRepo.save(testUser);
        LocalUser result = localUserRepo.findLocalUserByEmail(testUser.getEmail());
        assertEquals(result, testUser);
    }

    @Test
    public void testSaveLocalUser(){
        localUserRepo.save(testUser);
        LocalUser result = entityManager.find(LocalUser.class, testUser.getEmail());
        assertEquals(result, testUser);
    }
}
