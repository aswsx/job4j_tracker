package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    private final List<String> rsl;

    public Shell() {
        this.rsl = new ArrayList<>();
        rsl.add("/");
    }

    public void cd(String path) {
        switch (path) {
            case "/":
                rsl.clear();
                rsl.add("/");
                break;
            case "..":
                if (rsl.size() > 1) {
                    rsl.remove(rsl.size() - 1);
                }
                break;
            default:
                String[] dirs = path.split("/");
                if (dirs.length > 1) {
                    for (String dir : dirs) {
                        if (dir.equals("")) {
                            continue;
                        }
                        cd(dir);
                    }
                } else {
                    if (!rsl.get(rsl.size() - 1).equals("/")) {
                        rsl.add("/");
                    }
                    rsl.add(path);
                }
        }

        String[] pathArr = path.split("/");
        for (String s : pathArr) {
            System.out.print(s + " ");
        }
        System.out.println(pathArr.length);
    }

    public String pwd() {
        StringBuilder str = new StringBuilder();
        for (String s : rsl) {
            str.append(s);
        }
        return str.toString();
    }
}