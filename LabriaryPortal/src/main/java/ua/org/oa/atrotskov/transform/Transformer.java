package ua.org.oa.atrotskov.transform;

import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.model.dto.ReportDTO;
import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.Report;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kovantonlenko on 11/20/2015.
 */
public class Transformer {

    public static User transformUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setAdmin(userDTO.getAdmin());
        user.setBirthday(userDTO.getBirthday());
        if (userDTO.getBooks() != null) {
            List<BookDTO> booksDTO = userDTO.getBooks();
            List<Book> books = new ArrayList<>();
            for (BookDTO bookDTO : booksDTO) {
                books.add(Transformer.transformBookDTO(bookDTO));
            }
            user.setBooks(books);
        }
        return user;
    }

    public static UserDTO transformUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setAdmin(user.getAdmin());
        userDTO.setBirthday(user.getBirthday());
        if (user.getBooks() != null) {
            List<Book> books = user.getBooks();
            List<BookDTO> booksDTO = new ArrayList<>();
            for (Book book : books) {
                booksDTO.add(Transformer.transformBook(book));
            }
            userDTO.setBooks(booksDTO);
        }
        return userDTO;
    }

    public static Book transformBookDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCount(bookDTO.getCount());
        book.setReports(bookDTO.getReports());
        book.setUsers(bookDTO.getUsers());
        return book;
    }

    public static BookDTO transformBook(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setCount(book.getCount());
        bookDTO.setReports(book.getReports());
        bookDTO.setUsers(book.getUsers());
        return bookDTO;
    }

    public static Report transformReportDTO (ReportDTO reportDTO){
        Report report = new Report();
        report.setId(reportDTO.getId());
        report.setBook(reportDTO.getBook());
        report.setUser(reportDTO.getUser());
        report.setRentBook(reportDTO.getRentBook());
        report.setReturnBook(reportDTO.getReturnBook());
        return report;
    }

    public static ReportDTO transformReport (Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setBook(report.getBook());
        reportDTO.setUser(report.getUser());
        reportDTO.setRentBook(report.getRentBook());
        reportDTO.setReturnBook(report.getReturnBook());
        return reportDTO;
    }

}
