package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.service.api.BookService;
import ua.org.oa.atrotskov.service.api.UserService;
import ua.org.oa.atrotskov.service.impl.BookServiceImpl;
import ua.org.oa.atrotskov.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by jdev on 25.12.2015.
 */

public class AuthoriseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/authorise.jsp");
            rd.forward(req, resp);
        } else if ((user.getLogin() == req.getParameter("login")) && (user.getPassword() == req.getParameter("password"))) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/authorise.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService instanceUserService = UserServiceImpl.getInstance();
        UserDTO user = instanceUserService.getUserByLogin(login);
        if (user.getLogin() != null && user.getPassword().equals(password)) {
            BookService instanceBookService = BookServiceImpl.getInstance();
            user.setBooks(instanceBookService.getBooksByUser(user));
            HttpSession session = req.getSession();
            session.setAttribute("userBooks", user.getBooks());
            session.setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            String message = "Invalid login or password";
            req.setAttribute("message", message);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/authorise.jsp");
            rd.forward(req, resp);
        }
    }
}
