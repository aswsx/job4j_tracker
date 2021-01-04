package ru.job4j.bank;

import java.util.Objects;

/**
 *
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     *
     * @param requisite принимет на вход номер счета
     * @param balance принимает на вход сумму
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     *
     * @return возвращает номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     *
     * @param requisite принимает на вход номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     *
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance принимает на вход баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @param o принимает на вход объект
     * @return возвращаетрезультат проверки уникальности счета
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     *
     * @return возвращает уникальный hash-код счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
