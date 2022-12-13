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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_test")
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_affiliate")
    private Affiliate affiliate;

    public Appointment() {
    }

    public Appointment(int appointmentId, Date dateExam, Time hora, Test test, Affiliate affiliate) {
        this.appointmentId = appointmentId;
        this.dateExam = dateExam;
        this.hora = hora;
        this.test = test;
        this.affiliate = affiliate;
    }

    public Appointment(Date dateExam, Time hora, Test test, Affiliate affiliate) {
        this.dateExam = dateExam;
        this.hora = hora;
        this.test = test;
        this.affiliate = affiliate;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", dateExam=" + dateExam +
                ", hora=" + hora +
                ", test=" + test +
                ", affiliate=" + affiliate +
                '}';
    }
}