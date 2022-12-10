package com.citas.agendamiento.controller;

import com.citas.agendamiento.AgendamientoApplication;
import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.repository.AffiliateRepository;
import com.citas.agendamiento.service.AffiliateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AffiliatesControllerTest {



    @Autowired
    Affiliate affiliate;


    AffiliateRepository affiliateRepository = Mockito.mock(AffiliateRepository.class);

    @Autowired
    AffiliatesController affiliatesController = new AffiliatesController();

    @BeforeEach
    void setUp() {



        Mockito.when(affiliatesController.getAllAffiliate());
    }


    @Test
    void getAllAffiliate() {
    }

    @Test
    void getAffiliateByUd() {
    }

    @Test
    void addAffiliate() {
    }

    @Test
    void updateAffiliate() {
    }

    @Test
    void deletedAffiliate() {
    }
}