package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Test;
import com.citas.agendamiento.service.TestsService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

@WebMvcTest(TestsController.class)
class TestsControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    private Test testOne;

   private Test testTwo;

   @MockBean
   private TestsService testsService;

   @BeforeEach
   void setUp(){

       testOne = new Test(1,"prueba de sangre","se toma una muestra de sangre");
       testTwo = new Test(2,"prueba de orina","se toma una muestra de orina");
   }

    @org.junit.jupiter.api.Test
    void getAllTests() throws Exception {
        List<Test> testList = new  ArrayList<>();
        testList.add(testOne);
        testList.add(testTwo);
        Gson gson = new Gson();

        Mockito.when(testsService.getAllTests()).thenReturn(testList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/tests/allTests/")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].name", is("prueba de sangre"))
        );
    }

    @org.junit.jupiter.api.Test
    void getTestsById() throws Exception {
       int testId = 1;

       Mockito.when(testsService.getTestById(testId)).thenReturn(testOne);

       mockMvc.perform(MockMvcRequestBuilders.get("/tests/getById/{id}", 1)
       ).andExpect(
               MockMvcResultMatchers.status().is(200)
       ).andExpect(
               MockMvcResultMatchers.jsonPath("$.name", is("prueba de sangre"))
       );
    }

    @org.junit.jupiter.api.Test
    void addTest() {
    }

    @org.junit.jupiter.api.Test
    void updateTest() {
    }

    @org.junit.jupiter.api.Test
    void deletedTest() {
    }
}