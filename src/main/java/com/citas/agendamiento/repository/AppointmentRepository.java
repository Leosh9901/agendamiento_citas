package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Query(value = "SELECT COUNT(app.id_appointment) numCitas, aff.id_affiliate as affiliateId, aff.name, app.date " +
            "FROM appointments app " +
            "INNER JOIN affiliates aff " +
            "ON  app.id_affiliate = aff.id_affiliate " +
            "WHERE app.date = '2022-12-03' " +
            "GROUP BY aff.id_affiliate ",
            nativeQuery = true
    )
    List<AppointmentByDate> findAllAppointmentByDateExam(@Param("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);

}