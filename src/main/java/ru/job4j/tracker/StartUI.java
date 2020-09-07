package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

        public void init(Scanner scanner, Tracker tracker) {
            boolean run = true;
            while (run) {
                this.showMenu();
                /* if */
            }
        }

        private void showMenu() {
            System.out.println("Menu.");
            /* добавить остальные пункты меню. */
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Tracker tracker = new Tracker();
            new StartUI().init(scanner, tracker);
        }
        // Item item = new Item();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        //   String currentDateTimeFormat = item.getCreated().format(formatter);
        //  System.out.println(currentDateTimeFormat);
        //System.out.println(item);
    }

