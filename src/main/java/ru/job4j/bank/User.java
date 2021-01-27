package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка
 */
public class User {
    private String passport;
    private String username;

    /**
     *Конструктор
     * @param passport принимет на вход паспорт клиента
     * @param username принимает на вход имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     *Геттер
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     *Сеттер
     * @param passport принимает на вход паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     *Геттер
     * @return возвращает имя клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     *Сеттер
     * @param username принимает на вход имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *Метод, проверяющий уникальность клиента по паспорту
     * @param o принимаемый на вход объект
     * @return метод возвращает true, если клиент существует или false если не существует
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     *
     * @return Метод возвращает уникальный hash-код клиента
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

