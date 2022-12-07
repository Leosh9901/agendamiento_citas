package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Query("Select new com.citas.agendamiento.model.AppointmentByDate" +
            "(" +
            "count(app.appointmentId) as numAppointment, " +
            "aff.affiliateId, " +
            "aff.name, " +
            "app.date, " +
            "alqj.fechaFinal " +
            ")" +
            "From Affiliate aff " +
            "INNER JOIN aff.appointments app" +
            "WHERE alqj.estado = 1 AND rol.idRol = 3 " +
            "ORDER BY per.idPersona ASC"
    )
    List<AppointmentByDate> findAllAppointmentByDate();






}
