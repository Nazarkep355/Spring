package com.example.springfinalproject.controllers;

import com.example.springfinalproject.Controllers.MainController;
import com.example.springfinalproject.Services.UtilityService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class MainControllerTest {
    @Mock
    UtilityService utilityService;
    MainController controller;

    public MainControllerTest(){
        MockitoAnnotations.initMocks(this);
        controller = new MainController(utilityService);
    }

    @Test
    void redirectOnHomeTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"));
    }
    @Test
    void LoginPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        MockMvcResultMatchers.request().sessionAttribute("locale","locale_en");
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.view().name("login.html"));}

}
