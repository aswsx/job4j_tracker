package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book theGreatGatsby = new Book("The Great Gatsby", 125);
        Book cleanCode = new Book("Clean Code", 245);
        Book mobyDick = new Book("Moby Dick", 178);
        Book warAndPeace = new Book("War and Peace", 834);
        Book[] books = new Book[4];
        books[0] = theGreatGatsby;
        books[1] = cleanCode;
        books[2] = mobyDick;
        books[3] = warAndPeace;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPagesQty());
        }
        System.out.println("");
        System.out.println("Replace 0 <==> 3");
        Book replace = books[0];
        books[0] = books[3];
        books[3] = replace;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPagesQty());
        }
        System.out.println("");
        System.out.println("Clean Code only");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.equals(cleanCode)) {
                System.out.println(book.getName() + " - " + book.getPagesQty());
            }
        }
    }
}
