package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> rsl;
    private List<Integer> temp;

    static class Builder {
        private List<Integer> rsl;
        private List<Integer> temp;

        Builder buildRsl(List<Integer> rsl) {
            this.rsl = rsl;
            return this;
        }

        Builder buildTemp() {
            this.temp = new ArrayList<>();
            return this;
        }

        EasyStream build() {
            EasyStream easyStream = new EasyStream();
            easyStream.rsl = rsl;
            easyStream.temp = temp;
            return easyStream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildRsl(source)
                .buildTemp()
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int elem : rsl) {
            temp.add(fun.apply(elem));
        }
        return new EasyStream();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        for (int elem : rsl) {
            if (fun.test(elem)) {
                temp.add(elem);
            }
        }
        return new EasyStream();
    }

    public List<Integer> collect() {
        return rsl;
    }
}
