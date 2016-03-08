package ua.org.oa.atrotskov.util;

import ua.org.oa.atrotskov.exceptions.IncorrectInput.user.IncorectNameException;
import ua.org.oa.atrotskov.model.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jdev on 28.12.2015.
 */
public class Utils {
    private static final String PROP_PATH = "C:\\Users\\jdev\\IdeaProjects\\LabriaryPortal\\src\\main\\resources\\db_setting.properties";
    private static final String IS_JDBC = "is.jdbc";
    private static String DRIVER_NAME = "driverName";
    private static String URL = "jdbc:mysql://localhost:3306/labriary";
    private static String MY_SQL_USER = "root";
    private static String MY_SQL_PASSWORD = "root";

    public static Date convertHtmlDate (String strDate){
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date result = null;
        try {
            result = df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static UserDTO getUserDtoFromRequest(HttpServletRequest req){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(req.getParameter("name"));
        userDTO.setLogin(req.getParameter("login"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setBirthday(convertHtmlDate(req.getParameter("birthday")));
        return userDTO;
    }

}
