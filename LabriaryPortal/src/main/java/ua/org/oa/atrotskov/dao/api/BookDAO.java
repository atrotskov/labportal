package ua.org.oa.atrotskov.dao.api;

import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;

/**
 * Created by jdev on 29.11.2015.
 */
public interface BookDAO {
    public boolean addBook(Book book);
    public Book getBookById(long id);
    public boolean updateBook(Book book);
    public boolean deleteBookById(long id);
    public ArrayList<Book> getAllBooks();

    public ArrayList<Book> getBooksByTitle(String title);
    public ArrayList<Book> getBooksByAuthor(String author);
    public ArrayList<Book> getBooksByUser(User user);
}
