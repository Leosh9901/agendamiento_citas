package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Appointment;
import com.citas.agendamiento.model.AppointmentByAffiliate;
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

    @Query("SELECT new com.citas.agendamiento.model.AppointmentByDate" +
            "(" +
            "COUNT(app.appointmentId) as num, " +
            "aff.affiliateId, " +
            "aff.name, " +
            "app.dateExam " +
            ")" +
            "FROM Appointment app " +
            "INNER JOIN app.affiliate aff " +
            "WHERE app.dateExam = ?1 " +
            "GROUP BY aff.affiliateId"
    )
    List<AppointmentByDate> findAllAppointmentByDateExam(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date);

    @Query("SELECT new com.citas.agendamiento.model.AppointmentByAffiliate" +
            "(" +
            "aff.affiliateId, " +
            "aff.name, " +
            "app.hora, " +
            "app.dateExam, " +
            "app.test.testsId " +
            ")" +
            "FROM Appointment app " +
            "INNER JOIN app.affiliate aff " +
            "WHERE aff.affiliateId = :id "
    )
    List<AppointmentByAffiliate> findAppointmentByAffiliate(@Param("id") int affiliateId);


}