package ru.job4j.sort;

import ru.job4j.model.Item;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SortItemCheck {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, "1st item", Timestamp.valueOf(LocalDateTime.now())),
                new Item(2, "2nd item", Timestamp.valueOf(LocalDateTime.now())),
                new Item(4, "4th item", Timestamp.valueOf(LocalDateTime.now())),
                new Item(3, "3rd item", Timestamp.valueOf(LocalDateTime.now())),
                new Item(5, "5th item", Timestamp.valueOf(LocalDateTime.now())));

        System.out.println("До сортировки");
        System.out.println(items);
        System.out.println("сортировка по дате по возрастанию");
        items.sort(new SortItemUpCreated());
        System.out.println(items);
        System.out.println("Сортировка по дате по убыванию");
        items.sort(new SortItemDownCreated());
        System.out.println(items);
        System.out.println("По имени по возрастанию");
        items.sort(new SortItemUpName());
        System.out.println(items);
        System.out.println("по имени по убыванию");
        items.sort(new SortItemDownName());
        System.out.println(items);
        System.out.println("по id по возрастанию");
        items.sort(new SortItemUpId());
        System.out.println(items);
        System.out.println("по id по убыванию");
        items.sort(new SortItemDownId());
        System.out.println(items);
    }
}