package ua.org.oa.atrotskov.model.dto;

import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.Date;

/**
 * Created by jdev on 03.12.2015.
 */
public class ReportDTO {
    private long id;
    Book book;
    User user;
    Date rentBook;
    Date returnBook;

    @Override
    public String toString() {
        return "ReportDTO{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", rentBook=" + rentBook +
                ", returnBook=" + returnBook +
                '}';
    }

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
