package com.citas.agendamiento.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AppointmentByDate {


    private long numCitas;

    private int affiliateId;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public AppointmentByDate() {
    }

    public AppointmentByDate(long numCitas, int affiliateId, String name, Date date) {
        this.numCitas = numCitas;
        this.affiliateId = affiliateId;
        this.name = name;
        this.date = date;
    }

    public long getNumCitas() {
        return numCitas;
    }

    public void setNumCitas(long numCitas) {
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
