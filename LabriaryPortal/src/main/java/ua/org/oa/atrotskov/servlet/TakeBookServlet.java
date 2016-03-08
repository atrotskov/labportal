package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.service.api.BookService;
import ua.org.oa.atrotskov.service.api.UserService;
import ua.org.oa.atrotskov.service.impl.BookServiceImpl;
import ua.org.oa.atrotskov.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jdev on 03.01.2016.
 */
public class TakeBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/authorise.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService instanceUserService = UserServiceImpl.getInstance();
        BookService instanceBookService = BookServiceImpl.getInstance();

        // Take book Id from request
        String param = req.getParameter("id");
        long bookId = Long.parseLong(param);

        // Take user Id from session

        HttpSession sess = req.getSession();
        UserDTO userDTO = (UserDTO) sess.getAttribute("user");
        if (userDTO == null) {
            resp.sendRedirect("/authorise");
        } else {
            long userId = userDTO.getId();

            if (instanceUserService.isUserHaveThisBook(userId, bookId)) {
                String inf = "You already have this book";
                sess.setAttribute("message", inf);
                resp.sendRedirect("/home");

            } else {
                instanceUserService.doUserTakeBook(userId, bookId);

                // Put updated books in the session

                sess.setAttribute("listAllBooks", instanceBookService.getAllBooks());
                userDTO.setBooks(instanceBookService.getBooksByUser(userDTO));
                sess.setAttribute("userBooks", userDTO.getBooks());
                resp.sendRedirect("/home");
            }
        }
    }
}
