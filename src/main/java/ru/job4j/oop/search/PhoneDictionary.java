package ru.job4j.oop.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> combine = address.or(name).or(phone).or(surname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}