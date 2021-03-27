package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> rsl;
    private final List<Integer> temp = new ArrayList<>();

    private EasyStream(List<Integer> rsl) {
        this.rsl = rsl;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (Integer integer : rsl) {
            temp.add(fun.apply(integer));
        }
        return new EasyStream(temp);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        for (int elem : rsl) {
            if (fun.test(elem)) {
                temp.add(elem);
            }
        }
        return new EasyStream(temp);
    }

    public List<Integer> collect() {
        return rsl;
    }

//    public static class Builder {
//        private EasyStream eStream; //создаем переменную класса EasyStream
//
//        private Builder() {
//            eStream = new EasyStream(source); //конструктор создает объект EasyStream
//        }
//
//        public Builder listToStream(List<Integer> source) { //??? пройти итератором по
//            // принимаемому на вход List<Integer>? iterator или listIterator? Что сделать с
//            //полученными элементами?
//            ListIterator<Integer> literator = source.listIterator();
//            return this;
//        }
//
//        public Builder res() { //??? что дальше? вернуть какой-то результат? какой?
//            return this;
//        }
//
//        public EasyStream build() { //метод возвращает собранное лего
//            return eStream;
//        }
    //}
}
