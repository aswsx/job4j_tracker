package ru.job4j.tracker.ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Алексей");
        student.setSecondName("Федорович");
        student.setLastName("Гуторов");
        student.setGroup("ATE");
        student.setAdmitted(new Date());

        System.out.println("Student " + student.getName() + " " + student.getSecondName() + " "
                + student.getLastName() + " admitted " + student.getAdmitted() + " to the group " + student.getGroup());
    }
}
