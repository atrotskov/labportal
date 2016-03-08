package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.service.api.BookService;
import ua.org.oa.atrotskov.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jdev on 14.01.2016.
 */
public class AddNewBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDTO book = new BookDTO();
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        book.setId(Integer.parseInt(req.getParameter("count")));
        BookService bookService = BookServiceImpl.getInstance();
        bookService.addBook(book);
        resp.sendRedirect("/admin");
    }
}