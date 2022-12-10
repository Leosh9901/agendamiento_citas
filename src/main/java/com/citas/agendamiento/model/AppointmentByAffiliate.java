package com.citas.agendamiento.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.util.Date;

public class AppointmentByAffiliate {

    private int affiliateId;

    private String name;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date hour;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private int testId;

    public AppointmentByAffiliate() {
    }

    public AppointmentByAffiliate(int affiliateId, String name, Date hour, Date date, int testId) {
        this.affiliateId = affiliateId;
        this.name = name;
        this.hour = hour;
        this.date = date;
        this.testId = testId;
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

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "AppointmentByAffiliate{" +
                "affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                ", date=" + date +
                ", testId=" + testId +
                '}';
    }
}
