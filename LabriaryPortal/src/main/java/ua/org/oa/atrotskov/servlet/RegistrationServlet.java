package ua.org.oa.atrotskov.servlet;

import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.service.api.UserService;
import ua.org.oa.atrotskov.service.impl.UserServiceImpl;
import ua.org.oa.atrotskov.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jdev on 27.12.2015.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/resources/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = Utils.getUserDtoFromRequest(req);

        UserService service = UserServiceImpl.getInstance();



        /*if (service.isLoginExist(userDTO)) {
            System.out.println("login exist");
        } else {
            System.out.println("OK");
        }*/

        userDTO.setId(service.addUser(userDTO));

        /*валидация всех полей*/

       // User user = new User(firstName, lastName, login, password, gender);

        /*сохраняем нашего пользователя*/

        HttpSession session = req.getSession();
        session.setAttribute("user", userDTO);
        resp.sendRedirect("/home");
        //req.getRequestDispatcher("/home").forward(req, resp);
    }
}
