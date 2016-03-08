package ua.org.oa.atrotskov.dao.impl;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.storage.InDbStorage;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;

/**
 * Created by jdev on 26.12.2015.
 */
public class BookDaoDbImpl implements BookDAO {
    private InDbStorage instance = InDbStorage.getInstance();
    private static BookDAO bookDAO;
    private BookDaoDbImpl() {
    }

    public synchronized static BookDAO getInstance() {
        if (bookDAO == null) {
            bookDAO = new BookDaoDbImpl();
        }
        return bookDAO;
    }

    @Override
    public boolean addBook(Book book) {
        return instance.addBook(book);
    }

    @Override
    public Book getBookById(long id) {
        return instance.getBookById(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return instance.updateBook(book);
    }

    @Override
    public boolean deleteBookById(long id) {
        return instance.deleteBookById(id);
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return instance.getAllBooks();
    }

    @Override
    public ArrayList<Book> getBooksByTitle(String title) {
        return instance.getBooksByTitle(title);
    }

    @Override
    public ArrayList<Book> getBooksByAuthor(String author) {
        return instance.getBooksByAuthor(author);
    }

    @Override
    public ArrayList<Book> getBooksByUser(User user) {
        return instance.getBooksByUser(user);
    }
}
