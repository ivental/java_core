package ru.mentee.power.methods.library;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }


    @Override
    public String toString() {
        return "\"" + title + "\", \"" + author + "\", " + year;
    }
}
