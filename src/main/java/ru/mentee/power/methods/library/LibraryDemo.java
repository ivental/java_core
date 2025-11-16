package ru.mentee.power.methods.library;

import java.util.Arrays;

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library(4);
        Book firstBook = new Book("Война и мир", "Лев Толстой", 1869);
        Book secondBook = new Book("Преступление и наказание", "Федор Достоевский", 1866);
        Book thirdBook = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        library.addBook(firstBook);
        library.addBook(secondBook);
        library.addBook(thirdBook);

        System.out.println("Список доступных книг: " + Arrays.toString(library.listAvailableBooks()));
        System.out.println("Cписок выданных книг: " + Arrays.toString(library.listCheckedOutBooks()));

        boolean checkout1 = library.checkoutBook("Война и мир");
        if (checkout1) {
            System.out.println("Книга 'Война и мир' успешно выдана");
        } else {
            System.out.println("Не удалось выдать книгу 'Война и мир'");
        }
        boolean checkout2 = library.checkoutBook("Мастер и Маргарита");
        if (checkout2) {
            System.out.println("Книга 'Мастер и Маргарита' успешно выдана");
        } else {
            System.out.println("Не удалось выдать книгу 'Мастер и Маргарита'");
        }

        System.out.println("На данный момент доступны книги " + Arrays.toString(library.listAvailableBooks()));
        System.out.println("Список выданных книг " + Arrays.toString(library.listCheckedOutBooks()));

        boolean return1 = library.returnBook("Война и мир");
        if (return1) {
            System.out.println("Книга 'Война и мир' успешно возвращена");
        } else {
            System.out.println("Не удалось вернуть книгу 'Война и мир'");
        }
        boolean return2 = library.returnBook("Мастер и Маргарита");
        if (return2) {
            System.out.println("Книга 'Мастер и Маргарита' успешно возвращена");
        } else {
            System.out.println("Не удалось вернуть книгу 'Мастер и Маргарита'");
        }

        System.out.println("Список доступных книг: " + Arrays.toString(library.listAvailableBooks()));
        System.out.println("Cписок выданных книг: " + Arrays.toString(library.listCheckedOutBooks()));
    }
}
