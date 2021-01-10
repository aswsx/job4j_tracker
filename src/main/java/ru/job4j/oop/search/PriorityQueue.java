package ru.job4j.oop.search;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 *
 * @author STAS KOROBEYNIKOV
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение задание осуществляется в коллекции типа LinkedList
     */
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку на вход и добавляет ее в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     *
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     *
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */

    public Task take() {
        return tasks.poll();
    }
}
