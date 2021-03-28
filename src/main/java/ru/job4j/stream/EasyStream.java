package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> rsl;

    static class Builder {
        private List<Integer> rsl;

        Builder buildRsl(List<Integer> rsl) {
            this.rsl = rsl;
            return this;
        }

        EasyStream build() {
            EasyStream easyStream = new EasyStream();
            easyStream.rsl = rsl;
            return easyStream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildRsl(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (int elem : rsl) {
            temp.add(fun.apply(elem));
        }
        rsl = temp;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (int elem : rsl) {
            if (fun.test(elem)) {
                temp.add(elem);
            }
        }
        rsl = temp;
        return this;
    }

    public List<Integer> collect() {
        return rsl;
    }
}
