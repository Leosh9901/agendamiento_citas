package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.service.AffiliateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AffiliatesController.class)
class AffiliatesControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    private Affiliate affiliateOne;

    private Affiliate affiliateTwo;




    @MockBean
    private AffiliateService affiliateService;

    @BeforeEach
    void setUp() {


        affiliateOne = new Affiliate(2, "nicolas", 22, "nico@gmail.com");
        affiliateTwo = new Affiliate(3, "luis", 27, "luis@gmail.com");
    }

    @Test
    void getAllAffiliate() throws Exception {

        List<Affiliate> affiliateList = new ArrayList<>();
        affiliateList.add(affiliateOne);
        affiliateList.add(affiliateTwo);

        Mockito.when(affiliateService.getAllAffiliates()).thenReturn(affiliateList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/affiliates/allAffiliates")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[1].age", is(27))
        );
    }

    @Test
    void getAffiliateById() throws Exception {

        int affiliateId = 2;

        Mockito.when(affiliateService.getAffiliateById(affiliateId)).thenReturn(affiliateOne);

        mockMvc.perform(MockMvcRequestBuilders.get("/affiliates/getById/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.affiliateId", is(2))
        );
    }


    @Test
    void addAffiliate() throws Exception {
        affiliateOne = new Affiliate("paco", 18, "paco@gmail.com");
        Gson gson = new Gson();

        Mockito.when(affiliateService.addOrUpdateAffiliate(affiliateOne)).thenReturn(affiliateOne);

        mockMvc.perform(MockMvcRequestBuilders.post("/affiliates/addAffiliate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(affiliateOne))
        ).andExpect(
                MockMvcResultMatchers.status().is(201)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateAffiliate() throws Exception {
        affiliateOne = new Affiliate(2, "paco", 18, "paco@gmail.com");

        Gson gson = new Gson();

        Mockito.when(affiliateService.addOrUpdateAffiliate(affiliateOne)).thenReturn(affiliateTwo);

        mockMvc.perform(MockMvcRequestBuilders.put("/affiliates/updateAffiliate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(affiliateOne))
        ).andExpect(
                MockMvcResultMatchers.status().is(201)
        ).andExpect(status().isCreated());
    }

    @Test
    void deletedAffiliate() throws Exception {
        int affiliateId = 2;

        Mockito.when(affiliateService.deletedAffiliate(affiliateId)).thenReturn(affiliateOne);

        mockMvc.perform(MockMvcRequestBuilders.delete("/affiliates/delete/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.affiliateId", is(2))
        );
    }

}