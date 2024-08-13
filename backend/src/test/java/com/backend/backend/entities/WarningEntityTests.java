package com.backend.backend.entities;

import com.backend.backend.Entity.Warning;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class WarningEntityTests {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testWarningPersistence(){
        Warning warning = new Warning();
        warning.setDid(1);
        warning.setMessage("Hello World!");

        entityManager.persist(warning);
        entityManager.flush();

        Warning result = entityManager.find(Warning.class, warning.getDid());

        assertNotNull(result);
        assertEquals(result.getMessage(), warning.getMessage());

    }
}
