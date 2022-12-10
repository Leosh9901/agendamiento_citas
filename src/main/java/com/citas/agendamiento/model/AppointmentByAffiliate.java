package com.citas.agendamiento.model;

import com.citas.agendamiento.entity.Test;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AppointmentByAffiliate {

    private int affiliateId;

    private String name;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date hour;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Test test;

    public AppointmentByAffiliate() {
    }

    public AppointmentByAffiliate(int affiliateId, String name, Date hour, Date date, Test test) {
        this.affiliateId = affiliateId;
        this.name = name;
        this.hour = hour;
        this.date = date;
        this.test = test;
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

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "AppointmentByAffiliate{" +
                "affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                ", date=" + date +
                ", test=" + test +
                '}';
    }
}
