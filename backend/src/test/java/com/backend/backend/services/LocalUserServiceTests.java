package com.backend.backend.services;

import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.LocalUserRepo;
import com.backend.backend.Service.LocalUserManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cglib.core.Local;

import static org.junit.jupiter.api.Assertions.*;
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
    public void testVerifyLocalUserByEmail_Success() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.verifyAccount(email, hashedPassword);

        assertEquals(result.getEmail(),email);
    }

    @Test
    public void testVerifyLocalUserByEmail_Fail_Password() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.verifyAccount(email, "wrongPassword");

        assertNull(result);
    }

    @Test
    public void testVerifyLocalUserByEmail_Fail_Email() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.verifyAccount("wrongEmail@gmail.com", hashedPassword);

        assertNull(result);
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
        LocalUser result = localUserManagementService.getLocalUserByEmail(email);

        assertEquals(result,user);
    }
    @Test
    public void testFindLocalUserByEmail_Fail() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(email)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.getLocalUserByEmail("wrongEmail@gmail.com");

        assertNull(result);
    }

    @Test
    public void testFindLocalUserByUsername_Fail() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(username)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.getLocalUserByEmail("wrongEmail@gmail.com");

        assertNull(result);
    }

    @Test
    public void testFindLocalUserByUsername_Success() {
        // Arrange
        String email = "test@example.com";
        String hashedPassword = "hashedPassword";
        String username = "testUser";

        LocalUser user = new LocalUser(email, username, hashedPassword);

        // Mock the behavior of localUserRepo to return the LocalUser directly
        when(localUserRepo.findLocalUserByEmail(username)).thenReturn(user);

        // Act
        LocalUser result = localUserManagementService.getLocalUserByEmail(user.getUsername());

        assertEquals(result,user);
    }
}