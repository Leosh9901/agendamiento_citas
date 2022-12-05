package com.citas.agendamiento.service;

import com.citas.agendamiento.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int appointmentId);

    Appointment addOrUpdateAppointment(Appointment appointment);

    Appointment deletedAppointment(int appointmentId) throws Exception;
}
