package ru.job4j.stream;

import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = (int) current.stream().dropWhile(previous::contains).count();
        info.deleted = (int) previous.stream().filter(o -> !current.contains(o)).count();
        info.changed = (int) previous.stream().
                filter(current::contains).
                filter(o -> !o.getName().equals(current.get(current.indexOf(o)).getName())).
                count();
        return info;
    }

    public static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }

            User user = (User) o;

            return getId() == user.getId();
        }

        @Override
        public int hashCode() {
            return getId();
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;
    }
}

