package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Алексей");
        student.setSecondName("Федорович");
        student.setLastName("Гуторов");
        student.setGroup("ATE");
        student.setAdmitted(new Date());
        String out1 = "Student " + student.getName() + " " + student.getSecondName() + " ";
        String out2 = student.getLastName() + " admitted " + student.getAdmitted();
        String out3 = " to the group " + student.getGroup();

        System.out.println(out1 + out2 + out3);
    }
}
