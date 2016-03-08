package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.UserDTO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jdev on 10.01.2016.
 */
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/authorise");
        } else if ((user.getLogin() == req.getParameter("login")) && (user.getPassword() == req.getParameter("password"))) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("/authorise");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/authorise.jsp");
        rd.forward(req, resp);
    }
}
