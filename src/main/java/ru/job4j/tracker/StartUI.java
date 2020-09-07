package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 -> StartUI.createItem(input, tracker);
                case 1 -> StartUI.showAllItems(tracker);
                case 2 -> StartUI.editItem(input, tracker);
                case 3 -> StartUI.deleteItem(input, tracker);
                case 4 -> StartUI.findByID(input, tracker);
                case 5 -> StartUI.findByName(input, tracker);
                case 6 -> {
                    System.out.println("=== Exit ===");
                    run = false;
                }
                default -> System.out.println("=== Error ===");
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create new Item ===");
        System.out.println("Enter name: ");
        String name = input.askStr("=== Enter name ===");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all Items ===");
        Item[] all = tracker.findAll();
        for (Item item : all) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ===");
        int id = input.askInt("=== Enter Id ===");
        String name = input.askStr("=== Enter name ===");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edited");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = input.askInt("=== Enter Id ===");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Error");
        }
    }

    public static void findByID(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("=== Enter Id ===");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ===");
        String name = input.askStr("=== Enter name ===");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0.Add new item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by Id");
        System.out.println("5.Find items by name");
        System.out.println("6.Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

