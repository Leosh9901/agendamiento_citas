package com.citas.agendamiento.model;

import java.util.Date;

public class AppointmentByDate {


    private int numCitas;

    private int affiliateId;

    private String name;

    private Date date;

    public AppointmentByDate() {
    }

    public AppointmentByDate(int numCitas, int affiliateId, String name, Date date) {
        this.numCitas = numCitas;
        this.affiliateId = affiliateId;
        this.name = name;
        this.date = date;
    }

    public int getNumCitas() {
        return numCitas;
    }

    public void setNumCitas(int numCitas) {
        this.numCitas = numCitas;
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
        return "AppointmentByDate{" +
                "numCitas=" + numCitas +
                ", affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
