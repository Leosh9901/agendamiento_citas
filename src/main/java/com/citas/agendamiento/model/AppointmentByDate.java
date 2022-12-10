package com.citas.agendamiento.model;

import com.citas.agendamiento.entity.Affiliate;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AppointmentByDate {


    private long numCitas;

    private Affiliate affiliate;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public AppointmentByDate() {
    }

    public AppointmentByDate(long numCitas, Affiliate affiliate, Date date) {
        this.numCitas = numCitas;
        this.affiliate = affiliate;
        this.date = date;
    }

    public long getNumCitas() {
        return numCitas;
    }

    public void setNumCitas(long numCitas) {
        this.numCitas = numCitas;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
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
                ", affiliate=" + affiliate +
                ", date=" + date +
                '}';
    }
}
