package com.citas.agendamiento.service.impl;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByDate;
import com.citas.agendamiento.repository.AppointmentRepository;
import com.citas.agendamiento.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public Appointment addOrUpdateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment deletedAppointment(int appointmentId) throws Exception {

        Appointment deletedAppointment = null;
        try {
            deletedAppointment= appointmentRepository.findById(appointmentId).orElse(null);
            if (deletedAppointment == null){
                throw new Exception("Appointment not available");
            }else {
                appointmentRepository.deleteById(appointmentId);
            }
        }catch (Exception ex){
            throw ex;
        }
        return deletedAppointment;
    }

    @Override
    public List<AppointmentByDate> findAllAppointmentByDateExam(String date) {
        System.out.println(date);
        return appointmentRepository.findAllAppointmentByDateExam(date);
    }


}
