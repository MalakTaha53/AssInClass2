package com.example.assinclass2;

public class Book {
    private String title;
    private String authar;
    private int pages;

    public Book(String title, String authar, int pages) {
        this.title = title;
        this.authar = authar;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthar() {
        return authar;
    }

    public void setAuthar(String authar) {
        this.authar = authar;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authar='" + authar + '\'' +
                ", pages=" + pages +
                '}';
    }
}
