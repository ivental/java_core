package ru.mentee.power.methods.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        library = new Library(10);
        book1 = new Book("Война и мир", "Лев Толстой", 1869);
        book2 = new Book("Преступление и наказание", "Федор Достоевский", 1866);
        book3 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("1984", "Джордж Оруэлл", 1949);
        assertThat(library.addBook(newBook)).isTrue();

        Book foundBook = library.findBookByTitle("1984");
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getAuthor()).isEqualTo("Джордж Оруэлл");
    }

    @Test
    void testFindBookByTitle() {
        Book foundBook = library.findBookByTitle("Война и мир");
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getAuthor()).isEqualTo("Лев Толстой");
        assertThat(foundBook.getYear()).isEqualTo(1869);

        Book notFoundBook = library.findBookByTitle("Неизвестная книга");
        assertThat(notFoundBook).isNull();
    }

    @Test
    void testCheckoutAndReturnBook() {
        assertThat(book1.isAvailable()).isTrue();
        assertThat(library.checkoutBook("Война и мир")).isTrue();
        assertThat(book1.isAvailable()).isFalse();
        assertThat(library.checkoutBook("Война и мир")).isFalse();
        assertThat(library.returnBook("Война и мир")).isTrue();
        assertThat(book1.isAvailable()).isTrue();
        assertThat(library.returnBook("Война и мир")).isFalse();
    }

    @Test
    void testListAvailableAndCheckedOutBooks() {
        assertThat(library.listAvailableBooks()).hasSize(3);
        assertThat(library.listCheckedOutBooks()).isEmpty();
        library.checkoutBook("Война и мир");
        library.checkoutBook("Мастер и Маргарита");
        assertThat(library.listAvailableBooks()).hasSize(1);
        assertThat(library.listCheckedOutBooks()).hasSize(2);
        library.returnBook("Война и мир");
        assertThat(library.listAvailableBooks()).hasSize(2);
        assertThat(library.listCheckedOutBooks()).hasSize(1);
    }

    @Test
    void testLibraryCapacity() {
        Library smallLibrary = new Library(2);
        assertThat(smallLibrary.addBook(book1)).isTrue();
        assertThat(smallLibrary.addBook(book2)).isTrue();
        assertThat(smallLibrary.addBook(book3)).isFalse();
    }

    @Test
    void testNull(){
        Library smallLibrary = new Library(2);
        assertThat(smallLibrary.addBook(null)).isFalse();
        assertThat(smallLibrary.checkoutBook(null)).isFalse();
        assertThat(smallLibrary.returnBook(null)).isFalse();

    }
}
