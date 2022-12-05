package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/allAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        List<Appointment> appointments = null;

        try {
            appointments = appointmentService.getAllAppointments();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int appointmentId) {
        Appointment appointment = null;

        try {
            appointment = appointmentService.getAppointmentById(appointmentId);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }

    @PostMapping("/addAppointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment appointments = null;

        try {
            appointments = appointmentService.addOrUpdateAppointment(appointment);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Appointment>(appointments, HttpStatus.OK);
    }


    @PutMapping("/updateAppointment")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        Appointment appointments = null;

        try {
            appointments = appointmentService.addOrUpdateAppointment(appointment);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Appointment>(appointments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointment> deletedAppointment(@PathVariable("id") int appointmentId) {
        Appointment appointment = null;

        try {
            appointment = appointmentService.deletedAppointment(appointmentId);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }
}
