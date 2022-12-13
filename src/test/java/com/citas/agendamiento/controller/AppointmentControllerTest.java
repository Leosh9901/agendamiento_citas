package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByAffiliate;
import com.citas.agendamiento.model.AppointmentByDate;
import com.citas.agendamiento.service.AppointmentService;
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

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;

@WebMvcTest(AppointmentController.class)
class AppointmentControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    private Appointment appointmentOne;

    private Appointment appointmentTwo;

    private com.citas.agendamiento.entity.Test test;

    private Affiliate affiliate;

    private Date dateExam;

    private Time hora;

    private LocalDate localDate;

    private LocalTime localTime;


    @MockBean
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        test = new com.citas.agendamiento.entity.Test(1, "prueba de sangre", "se toma una muestra de sangre");
        affiliate = new Affiliate(5, "camila", 27, "camila@gmail.com");

        hora = Time.valueOf(LocalTime.of(9, 35, 00));

        ZoneId defaultZoneId = ZoneId.systemDefault();
        localDate = LocalDate.of(2022, 12, 03);
        dateExam = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        appointmentOne = new Appointment(36, dateExam, hora, test, affiliate);
    }

    @Test
    void getAllAppointments() throws Exception {

        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointmentOne);


        Mockito.when(appointmentService.getAllAppointments()).thenReturn(appointmentList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointments/allAppointments/")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].appointmentId", is(36))
        );

    }

    @Test
    void getAppointmentById() throws Exception {

        int appointmentId = 36;

        Mockito.when(appointmentService.getAppointmentById(appointmentId)).thenReturn(appointmentOne);

        mockMvc.perform(MockMvcRequestBuilders.get("/appointments/getById/{id}", 36)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.appointmentId", is(36))
        );

    }

    @Test
    void addAppointment() throws Exception {

        appointmentOne = new Appointment(null, null, test, affiliate);
        Gson gson = new Gson();

        Mockito.when(appointmentService.addOrUpdateAppointment(appointmentOne)).thenReturn(appointmentOne);

        mockMvc.perform(MockMvcRequestBuilders.post("/appointments/addAppointment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(appointmentOne))
        ).andExpect(
                MockMvcResultMatchers.status().is(201)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateAppointment() throws Exception {

        appointmentOne = new Appointment(36, null, null, test, affiliate);
        Gson gson = new Gson();

        Mockito.when(appointmentService.addOrUpdateAppointment(appointmentOne)).thenReturn(appointmentOne);

        mockMvc.perform(MockMvcRequestBuilders.put("/appointments/updateAppointment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(appointmentOne))
        ).andExpect(
                MockMvcResultMatchers.status().is(201)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void deletedAppointment() throws Exception {

        int appointmentId = 36;

        Mockito.when(appointmentService.deletedAppointment(appointmentId)).thenReturn(appointmentOne);

        mockMvc.perform(MockMvcRequestBuilders.delete("/appointments/delete/{id}/", appointmentId)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.appointmentId", is(appointmentId))
        );

    }

    @Test
    void findAllAppointmentByDateExam() throws Exception {
        AppointmentByDate appointmentByDate = new AppointmentByDate();
        appointmentByDate.setDate(null);
        appointmentByDate.setAffiliate(affiliate);
        appointmentByDate.setNumCitas(3L);

        List<AppointmentByDate> appointmentByDateList = new ArrayList<>();
        appointmentByDateList.add(appointmentByDate);

        Mockito.when(appointmentService.findAllAppointmentByDateExam(dateExam)).thenReturn(appointmentByDateList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointments/appointmentByDate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", "2022-12-03")
        ).andExpect(MockMvcResultMatchers.status().is(200)
        ).andExpect(MockMvcResultMatchers.jsonPath("$[0].numCitas", is(3)));

    }

    @Test
    void findAppointmentByAffiliate() throws Exception {
        AppointmentByAffiliate appointmentByAffiliate = new AppointmentByAffiliate();
        appointmentByAffiliate.setAffiliateId(2);
        appointmentByAffiliate.setDate(null);
        appointmentByAffiliate.setName("nicolas");
        appointmentByAffiliate.setHour(null);
        appointmentByAffiliate.setTest(test);

        List<AppointmentByAffiliate> appointmentByAffiliateList = new ArrayList<>();
        appointmentByAffiliateList.add(appointmentByAffiliate);

        Mockito.when(appointmentService.findAppointmentByAffiliate(2)).thenReturn(appointmentByAffiliateList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointments/appointmentByAffiliate/{id}", 2)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().is(200)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].affiliateId", is(2)));


    }
}