package ru.mentee.power.methods.library;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity) {
        this.books = new Book[capacity];
    }

    public boolean addBook(Book book) {
        if (books.length > bookCount) {
            books[bookCount] = book;
            bookCount++;
            return true;
        } else {
            return false;
        }
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean checkoutBook(String title) {
        Book foundBook = findBookByTitle(title);
        if (foundBook == null) {
            return false;
        } else if (foundBook.isAvailable()) {
            foundBook.setAvailable(false);
        } else {
            return false;
        }
        return true;
    }

    public boolean returnBook(String title) {
        Book returnBook = findBookByTitle(title);
        if (returnBook == null) {
            return false;
        } else if (returnBook.isAvailable()) {
            return false;
        } else {
            returnBook.setAvailable(true);
        }

        return true;
    }

    public Book[] listAvailableBooks() {
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].isAvailable()) {
                count++;
            }
        }
        Book[] result = new Book[count];
        int resultIndex = 0;
        for (int index = 0; index < bookCount; index++) {
            if (books[index] != null && books[index].isAvailable()) {
                result[resultIndex] = books[index];
                resultIndex++;
            }
        }
        return result;
    }
    public Book[] listCheckedOutBooks() {
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] !=null && !books[i].isAvailable()){
                count++;
            }
        }
        Book[] result = new Book[count];
        int resultIndex = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && !books[i].isAvailable()){
                result [resultIndex] = books[i];
                resultIndex++;
            }
        }
        return result;
    }
}
