package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.service.AffiliateService;
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
        //Given =Arrange
        affiliateOne = new Affiliate(2, "nicolas", 22, "nico@gmail.com");
        affiliateTwo = new Affiliate(3, "luis", 27, "luis@gmail.com");
    }

    @Test
    void getAllAffiliate() throws Exception {
        //Data
        List<Affiliate> affiliateList = new ArrayList<>();
        affiliateList.add(affiliateOne);
        affiliateList.add(affiliateTwo);

        //When
        Mockito.when(affiliateService.getAllAffiliates()).thenReturn(affiliateList);

        //Then = Assert
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
    void getAffiliateById() {
        // 1
    }

    @Test
    void addAffiliate() {
     //   affiliate = new Affiliate("sdvsd", 12, "dssldkns");
    }

    @Test
    void updateAffiliate() {
      //  affiliate = new Affiliate(1, "sdvsd", 12, "dssldkns");
    }

    @Test
    void deletedAffiliate() {
        // 1
    }


}