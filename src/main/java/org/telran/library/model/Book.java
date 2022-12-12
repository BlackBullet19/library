package org.telran.library.model;

public class Book {

    private String name;

    private String author;

    private int pageCount;

    private int id;

    public Book(String name, String author, int pageCount, int id) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", id=" + id +
                '}';
    }
}
