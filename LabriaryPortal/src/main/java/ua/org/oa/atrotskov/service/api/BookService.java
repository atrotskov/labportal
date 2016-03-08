package ua.org.oa.atrotskov.service.api;

import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.model.dto.UserDTO;

import java.util.ArrayList;

/**
 * Created by jdev on 25.12.2015.
 */
public interface BookService {
    public BookDTO getBookById(long id);
    public boolean addBook(BookDTO bookDTO);
    public boolean updateBook(BookDTO bookDTO);
    public boolean deleteBook(BookDTO bookDTO);
    public ArrayList<BookDTO> getAllBooks();
    public ArrayList<BookDTO> getBooksByUser(UserDTO userDTO);
}
