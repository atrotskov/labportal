package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.UserDTO;
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
 * Created by jdev on 13.01.2016.
 */
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        UserDTO user = (UserDTO) sess.getAttribute("user");
        if (user != null) {
            if (user.getAdmin() == true) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/admin.jsp");
                rd.forward(req, resp);
            } else {
                sess.setAttribute("message", "Access is denied");
                resp.sendRedirect("/home");
            }
        } else {
            resp.sendRedirect("/authorise");
        }
    }
}
