package com.backend.backend.entities;

import com.backend.backend.Entity.LocalUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserEntityTests {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testUserPersistence() {
        LocalUser localUser = new LocalUser();
        localUser.setEmail("testEmail@gmail.com");
        localUser.setUsername("test1");
        localUser.setPassword("12345");

        entityManager.persist(localUser);
        entityManager.flush();

        LocalUser result = entityManager.find(LocalUser.class, localUser.getEmail());

        assertEquals(result.getUsername(), "test1");
        assertEquals(result.getEmail(), "testEmail@gmail.com");
        assertEquals(result.getPassword(), "12345");
    }

    @Test
    public void testAllArgumentConstructor(){
        LocalUser localUser = new LocalUser("test1@gmail.com", "test1", "12345");

        entityManager.persist(localUser);
        entityManager.flush();
        LocalUser result = entityManager.find(LocalUser.class, localUser.getEmail());

        assertEquals(result.getUsername(), "test1");
        assertEquals(result.getEmail(), "test1@gmail.com");
        assertEquals(result.getPassword(), "12345");
    }
}