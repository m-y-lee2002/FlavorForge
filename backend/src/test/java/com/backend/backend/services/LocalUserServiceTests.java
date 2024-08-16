package com.backend.backend.services;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import com.backend.backend.Service.LocalUserManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class LocalUserServiceTests {

    @InjectMocks
    private LocalUserManagementService localUserManagementService;

    @Mock
    private LocalUserRepo localUserRepo; // Mock instance of LocalUserRepo

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testFindLocalUserByEmail_Success() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        boolean result = localUserManagementService.verifyAccount(email, hashedPassword);

        assertTrue(result);
    }

    @Test
    public void testFindLocalUserByEmail_Fail_Password() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        boolean result = localUserManagementService.verifyAccount(email, "wrongPassword");

        assertFalse(result);
    }

    @Test
    public void testFindLocalUserByEmail_Fail_Email() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        boolean result = localUserManagementService.verifyAccount("wrongEmail@gmail.com", hashedPassword);

        assertFalse(result);
    }
}