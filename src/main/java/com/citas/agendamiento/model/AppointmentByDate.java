package com.citas.agendamiento.model;

import java.util.Date;

public class AppointmentByDate {


    private int numAppointment;

    private int affiliateId;

    private String name;

    private Date date;

    public AppointmentByDate() {
    }

    public AppointmentByDate(int numAppointment, int affiliateId, String name, Date date) {
        this.numAppointment = numAppointment;
        this.affiliateId = affiliateId;
        this.name = name;
        this.date = date;
    }

    public int getNumAppointment() {
        return numAppointment;
    }

    public void setNumAppointment(int numAppointment) {
        this.numAppointment = numAppointment;
    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AppointmentForDate{" +
                "numAppointment=" + numAppointment +
                ", affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
