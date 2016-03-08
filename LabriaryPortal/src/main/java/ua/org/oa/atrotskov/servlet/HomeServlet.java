package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.service.api.BookService;
import ua.org.oa.atrotskov.service.impl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jdev on 02.01.2016.
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService instanceBookService = BookServiceImpl.getInstance();
        HttpSession sess = req.getSession();
        if (sess.getAttribute("user") != null) {
            sess.setAttribute("listAllBooks", instanceBookService.getAllBooks());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/home.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("/authorise");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/home.jsp");
        rd.forward(req, resp);
    }
}
