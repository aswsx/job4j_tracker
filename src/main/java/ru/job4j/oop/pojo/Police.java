package ru.job4j.oop.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Alexey Gutorov");
        license.setModel("SAAB");
        license.setCode("217xxx");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car - " + license.getModel()
                + " : " + license.getCode());
    }
}
