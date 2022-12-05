package com.citas.agendamiento.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_appointment")
    private int appointmentId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date dateExam;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hour")
    private Time hora;

    @Column(name = "id_test")
    private int testId;

    @Column(name = "id_affiliate")
    private int affiliateId;

    public Appointment() {
    }

    public Appointment(int appointmentId, Date fecha, Time hora, int testId, int affiliateId) {
        this.appointmentId = this.appointmentId;
        this.dateExam = fecha;
        this.hora = hora;
        this.testId = testId;
        this.affiliateId = affiliateId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", dateExam=" + dateExam +
                ", hora=" + hora +
                ", testId=" + testId +
                ", affiliateId=" + affiliateId +
                '}';
    }
}