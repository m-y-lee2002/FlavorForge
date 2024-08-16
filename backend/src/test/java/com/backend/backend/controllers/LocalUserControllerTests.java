package com.backend.backend.controllers;

import com.backend.backend.Controller.LocalUserController;
import com.backend.backend.Controller.LocalUserManagementController;
import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Service.LocalUserManagementService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalUserManagementController.class)
public class LocalUserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalUserManagementService localUserManagementService;

    private static LocalUser testUser;
    @BeforeAll
    public static void setTestDummies(){
        testUser = new LocalUser("testEmail@gmail.com", "testUser1", "1234");
    }
    @Test
    public void testSuccesfulLogin() throws Exception {
        String goalEmail = testUser.getEmail();
        String goalPassword =  DigestUtils.sha1Hex(testUser.getPassword());
        // Arrange
        when(localUserManagementService.verifyAccount(goalEmail,goalPassword)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(get("/api/account/login/{email}/{password}", testUser.getEmail(), testUser.getPassword())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testFailedLoginWrongEmail() throws Exception {
        String goalEmail = "differentEmail@gmail.com";
        String goalPassword =  DigestUtils.sha1Hex(testUser.getPassword());
        // Arrange
        when(localUserManagementService.verifyAccount(goalEmail,goalPassword)).thenReturn(false);

        // Act & Assert
        mockMvc.perform(get("/api/account/login/{email}/{password}", testUser.getEmail(), testUser.getPassword())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
    @Test
    public void testFailedLoginWrongPassword() throws Exception {
        String goalEmail = testUser.getEmail();
        String goalPassword =  DigestUtils.sha1Hex("wrongPassword");
        // Arrange
        when(localUserManagementService.verifyAccount(goalEmail,goalPassword)).thenReturn(false);

        // Act & Assert
        mockMvc.perform(get("/api/account/login/{email}/{password}", testUser.getEmail(), testUser.getPassword())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void testFailedLoginWrongUnHashedPassword() throws Exception {
        String goalEmail = testUser.getEmail();
        String goalPassword =  testUser.getPassword();
        // Arrange
        when(localUserManagementService.verifyAccount(goalEmail,goalPassword)).thenReturn(false);

        // Act & Assert
        mockMvc.perform(get("/api/account/login/{email}/{password}", testUser.getEmail(), testUser.getPassword())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

}