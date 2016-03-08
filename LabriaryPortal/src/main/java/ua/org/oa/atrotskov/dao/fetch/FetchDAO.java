package ua.org.oa.atrotskov.dao.fetch;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.api.UserDAO;
import ua.org.oa.atrotskov.dao.impl.BookDaoDbImpl;
import ua.org.oa.atrotskov.dao.impl.BookDaoMemoryImpl;
import ua.org.oa.atrotskov.dao.impl.UserDaoDbImpl;
import ua.org.oa.atrotskov.dao.impl.UserDaoMemoryImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jdev on 23.12.2015.
 */
public class FetchDAO {
    private static String path = "db_setting.properties";
    private static boolean isMySql(String path) {
        boolean prop = false;
        InputStream stream = null;
        try {
            stream = FetchDAO.class.getClassLoader().getResourceAsStream(path);
            Properties properties = new Properties();
            properties.load(stream);
            String value = properties.getProperty("is.jdbc");
            if (value != null) {
                prop = Boolean.parseBoolean(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static UserDAO fetchUserDao() {
        UserDAO userDAO = null;
        if (isMySql(path)) {
            userDAO = UserDaoDbImpl.getInstance();
        } else {
            userDAO = UserDaoMemoryImpl.getInstance();
        }
        return userDAO;
    }

    public static BookDAO fetchBookDao() {
        BookDAO bookDAO = null;
        if (isMySql(path)) {
            bookDAO = BookDaoDbImpl.getInstance();
        } else {
            bookDAO = BookDaoMemoryImpl.getInstance();
        }
        return bookDAO;
    }
}
