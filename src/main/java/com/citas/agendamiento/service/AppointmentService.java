package com.citas.agendamiento.service;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByAffiliate;
import com.citas.agendamiento.model.AppointmentByDate;

import java.util.Date;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int appointmentId);

    Appointment addOrUpdateAppointment(Appointment appointment);

    Appointment deletedAppointment(int appointmentId) throws Exception;

    List<AppointmentByDate> findAllAppointmentByDateExam(Date date);

    List<AppointmentByAffiliate> findAppointmentByAffiliate(int affiliateId);
}
