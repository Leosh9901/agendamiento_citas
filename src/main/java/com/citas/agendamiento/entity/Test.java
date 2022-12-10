package com.citas.agendamiento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private int testsId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    public Test() {
    }

    public Test(int testsId, String name, String description, List<Appointment> appointments) {
        this.testsId = testsId;
        this.name = name;
        this.description = description;
        this.appointments = appointments;
    }

    public int getTestsId() {
        return testsId;
    }

    public void setTestsId(int testsId) {
        this.testsId = testsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testsId=" + testsId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}