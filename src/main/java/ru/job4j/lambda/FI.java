package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> cmpText = (left, right) -> {
            System.out.println("compare text - " + left.getName() + " : " + right.getName());
            return left.getName().compareTo(right.getName());
        };

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare length desc - " + left.getName().length() + " : " + right.getName().length());
            return Integer.compare(right.getName().length(), left.getName().length());
        };
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare size asc- " + left.getSize() + " : " + right.getSize());
            return left.getSize() - right.getSize();
        };
        Arrays.sort(atts, comparator);
        Arrays.sort(atts, cmpText);
        Arrays.sort(atts, cmpDescSize);
    }
}