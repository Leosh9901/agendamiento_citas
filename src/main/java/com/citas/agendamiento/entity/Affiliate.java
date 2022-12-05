package com.citas.agendamiento.entity;


import javax.persistence.*;

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

    public Affiliate() {
    }

    public Affiliate(int affiliateId, String name, int age, String mail) {
        this.affiliateId = affiliateId;
        this.name = name;
        this.age = age;
        this.mail = mail;
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

    @Override
    public String toString() {
        return "Affiliate{" +
                "affiliateId=" + affiliateId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }
}
