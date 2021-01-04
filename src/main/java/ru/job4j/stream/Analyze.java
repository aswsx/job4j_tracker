package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 */

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * @param stream принимает поток
     * @return возвращает средний балл
     * для реализации понадобятся методы:
     * <p>
     * - flatMap() для преобразования в поток объектов Subject;
     * <p>
     * - mapToInt() для последующего преобразования в поток оценок по каждому предмету;
     * <p>
     * - average() для расчета среднего бала по предмету;
     * <p>
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @param stream принимает поток
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     * - метод map() для преобразования в поток объектов класса Tuple, внутри метода мы
     * будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * <p>
     * - при этом в конструктор первым параметром будет передаваться имя текущего
     * объекта Pupil - используем соответствующий геттер;
     * <p>
     * - вторым параметром рассчитанный средний балл - расчет можно произвести по
     * той же последовательности, что описана для метода averageScore;
     * <p>
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    double score = pupil.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .average()
                            .orElse(0D);
                    return new Tuple(pupil.getName(), score);
                })
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     *
     * @param stream принимает поток
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     * - flatMap() для преобразования в поток объектов Subject;
     * <p>
     * - метод collect() в который мы передаем метод groupingBy() (минимум с двумя параметрами)
     * класса Collectors. При этом карта собирается следующим образом: ключ - это имя предмета,
     * значение - средний балл по этому предмету для каждого ученика. Для расчета среднего балла
     * используйте метод averagingDouble() класса Collectors;
     * <p>
     * - после этого собранную карту мы разбираем с помощью entrySet() и открываем поток
     * с помощью stream();
     * <p>
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple, внутри
     * метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * <p>
     * - в конструктор мы будем передавать параметры с помощью методов getKey() и getValue()
     * интерфейса Entry;
     * <p>
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)
                ))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим
     * баллом по всем предметам.
     *
     * @param stream принимает поток
     * @return возвращает лучшего ученика
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо
     * average() нужно использовать метод sum();
     * <p>
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     * <p>
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    double score = pupil.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .sum();
                    return new Tuple(pupil.getName(), score);
                })
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("JohnDoe", 0));
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream принимает поток
     * @return Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо
     * averagingDouble() нужно использовать метод summingDouble();
     * <p>
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     * <p>
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)
                ))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("JohnDoe", 0));
    }
}