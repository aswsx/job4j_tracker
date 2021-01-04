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
     * @param user клиент? добавляемый в базу
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет клиенту счет? если такого еще нет
     *
     * @param passport паспорт клиента к которому привязывается счет
     * @param account  добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccount = users.get(user);
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
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }
//        User user = null;
//        for (User key : users.keySet()) {
//            if (key.getPassport().equals(passport)) {
//                user = key;
//                break;
//            }
//        }
//        return user;

    /**
     * Метод находит клиента по счету
     *
     * @param passport  паспорт, принимаемый на вход
     * @param requisite искомый номер счета
     * @return возвращает клиента или null, если клиент не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
//        Account rslAccount = null;
//        User user = findByPassport(passport);
//        List<Account> accounts = users.get(user);
//        if (accounts != null) {
//            for (Account account : accounts) {
//                if (account.getRequisite().equals(requisite)) {
//                    rslAccount = account;
//                    break;
//                }
//            }
//        }
//        return rslAccount;
//   }

    /**
     * Метод переводит деньги между счетами
     *
     * @param srcPasspord   принимаемый на вход паспорт отправителя
     * @param srcRequisite  принимаемый на вход счет отправителя
     * @param destPassport  принимаемый на вход пасспорт получателя
     * @param destRequisite принимаемый на вход счет получателя
     * @param amount        принимаемая на вход сумма
     * @return метод возвращает true, если перевод был успешен или false в случае
     * неудачного перевода
     */
    public boolean transferMoney(String srcPasspord, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPasspord, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
