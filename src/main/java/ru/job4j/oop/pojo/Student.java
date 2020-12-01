package ru.job4j.oop.pojo;

import java.util.Date;

public class Student {
    private String name;
    private String secondName;
    private String lastName;
    private String group;
    private Date admitted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getAdmitted() {
        return admitted;
    }

    public void setAdmitted(Date admitted) {
        this.admitted = admitted;
    }
}
