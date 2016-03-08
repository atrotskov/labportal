package ua.org.oa.atrotskov.service.impl;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.fetch.FetchDAO;
import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.service.api.BookService;
import ua.org.oa.atrotskov.transform.Transformer;

import java.util.ArrayList;

/**
 * Created by jdev on 26.12.2015.
 */
public class BookServiceImpl implements BookService {
    // Init Singleton BookService Begin
    private static BookService bookService;
    private BookServiceImpl() {
    }

    public synchronized static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookServiceImpl();
        }
        return bookService;
    }
    // Init Singleton BookService End

    private BookDAO bookDAO = FetchDAO.fetchBookDao();


    @Override
    public BookDTO getBookById(long id) {
        Book book = bookDAO.getBookById(id);
        return Transformer.transformBook(book);
    }

    @Override
    public boolean addBook(BookDTO bookDTO) {
        Book book = Transformer.transformBookDTO(bookDTO);
        return bookDAO.addBook(book);
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        Book book = Transformer.transformBookDTO(bookDTO);
        return bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBook(BookDTO bookDTO) {
        Book book = Transformer.transformBookDTO(bookDTO);
        return bookDAO.deleteBookById(book.getId());
    }

    @Override
    public ArrayList<BookDTO> getAllBooks() {
        ArrayList<Book> books = bookDAO.getAllBooks();
        ArrayList<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(Transformer.transformBook(book));
        }
        return booksDTO;
    }

    @Override
    public ArrayList<BookDTO> getBooksByUser(UserDTO userDTO) {
        ArrayList<Book> books =  bookDAO.getBooksByUser(Transformer.transformUserDTO(userDTO));
        ArrayList<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(Transformer.transformBook(book));
        }
        return booksDTO;
    }
}
