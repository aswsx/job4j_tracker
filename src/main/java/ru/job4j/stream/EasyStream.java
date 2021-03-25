package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> rsl; //TODO выходной массив, возвращаемый методом collect
    //TODO для создания потока нужен итератор?

    //TODO метод принимает входной массив и ... Что и в каком виде он возвращает?
    public static EasyStream of(List<Integer> source) {
        throw new UnsupportedOperationException();
    }
    //TODO метод принимает элементы(из потока?) и применяет к ним функцию.
    // Как функция передается в метод? Как передать сюда поток?
    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }
    //TODO метод принимает элементы (из потока?) и применяет фильтр
    public EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }
    //TODO собрать элементы (из потока?) в массив(коллекцию) rsl
    public List<Integer> collect() {
        return rsl;
    }

    //TODO Билдер собирает в кучу методы, нужные для создания потока? Шаблон переделать
    public static class Builder {
        private EasyStream eStream; //создаем переменную класса EasyStream

        private Builder() {
            eStream = new EasyStream(); //конструктор создает объект EasyStream
        }

        public Builder listToStream(List<Integer> source) { //??? пройти итератором по
            // принимаемому на вход List<Integer>? iterator или listIterator? Что сделать с
            //полученными элементами?
            source.listIterator();
            return this;
        }

        public Builder res() { //??? что дальше? вернуть какой-то результат? какой?
            return this;
        }

        public EasyStream build() { //метод возвращает собранное лего
            return eStream;
        }
    }
}
