package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу простого банковского сервиса
 * Содержит базу клиентов с их счетами.
 * Позволяет найти клиента по пасспорту, по номеру счета,
 * добавить клиента, перевести деньги со счета на счет
 *
 * @author Alexey Gutorov
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает клиента на вход и добавляет его в базу
     * если его еще нет в базе
     *
     * @param user клиент, добавляемый в базу
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет клиенту счет, если такого еще нет
     *
     * @param passport паспорт клиента к которому привязывается счет
     * @param account  добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccount = users.get(user.get());
            if (userAccount != null) {
                if (!userAccount.contains(account)) {
                    userAccount.add(account);
                }
            }
        }
    }

    /**
     * Метод находит клиента по паспорту
     *
     * @param passport паспорт клиента, принимаемый на вход
     * @return возвращает найденного пользователя или null, если клиент не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит клиента по счету
     *
     * @param passport  паспорт, принимаемый на вход
     * @param requisite искомый номер счета
     * @return возвращает клиента или null, если клиент не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        return user.map(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()).orElse(rsl);
    }

    /**
     * Метод переводит деньги между счетами
     *
     * @param srcPassword   принимаемый на вход паспорт отправителя
     * @param srcRequisite  принимаемый на вход счет отправителя
     * @param destPassport  принимаемый на вход паспорт получателя
     * @param destRequisite принимаемый на вход счет получателя
     * @param amount        принимаемая на вход сумма
     * @return метод возвращает true, если перевод был успешен или false в случае
     * неудачного перевода
     */
    public boolean transferMoney(String srcPassword, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassword, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
