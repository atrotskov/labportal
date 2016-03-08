package ua.org.oa.atrotskov.dao.impl;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.storage.InMemoryStorage;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;

/**
 * Created by jdev on 17.12.2015.
 */
public class BookDaoMemoryImpl implements BookDAO {
    private static BookDAO bookDAO;
    private InMemoryStorage instance = InMemoryStorage.getInstance();

    private BookDaoMemoryImpl() {
    }

    public synchronized static BookDAO getInstance() {
        if (bookDAO == null) {
            bookDAO = new BookDaoMemoryImpl();
        }
        return bookDAO;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public Book getBookById(long id) {
        return null;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBookById(long id) {
        return false;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksByTitle(String title) {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksByAuthor(String author) {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksByUser(User user) {
        return null;
    }
}
