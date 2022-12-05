package com.citas.agendamiento.entity;

import javax.persistence.*;

@Entity
@Table(name = "tests")
public class Tests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_test")
    private int testsId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Tests() {
    }

    public Tests(int testsId, String name, String description) {
        this.testsId = testsId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Tests{" +
                "testsId=" + testsId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
