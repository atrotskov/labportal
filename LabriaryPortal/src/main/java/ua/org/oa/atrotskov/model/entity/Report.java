package ua.org.oa.atrotskov.model.entity;

import java.util.Date;

/**
 * Created by jdev on 26.11.2015.
 */
public class Report {
    private long id;
    Book book;
    User user;
    Date rentBook;
    Date returnBook;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRentBook() {
        return rentBook;
    }

    public void setRentBook(Date rentBook) {
        this.rentBook = rentBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }
}
