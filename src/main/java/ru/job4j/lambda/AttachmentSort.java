package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment attachment1, Attachment attachment2) {
                return attachment1.getSize() - attachment2.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator nameComparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment attachment1, Attachment attachment2) {
                return attachment1.getName().compareTo(attachment2.getName());
            }
        };
        attachments.sort(nameComparator);
        System.out.println(attachments);
    }
}