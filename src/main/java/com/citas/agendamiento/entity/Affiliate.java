package com.citas.agendamiento.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "affiliates")
public class Affiliate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_affiliate")
    private int affiliateId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "affiliate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    public Affiliate() {
    }

    public Affiliate(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public Affiliate(int affiliateId, String name, int age, String mail) {
        this.affiliateId = affiliateId;
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public Affiliate(int affiliateId, String name, int age, String mail, List<Appointment> appointments) {
        this.affiliateId = affiliateId;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.appointments = appointments;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Affiliate{" +
                "affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
