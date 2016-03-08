package ua.org.oa.atrotskov.dao.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by jdev on 17.12.2015.
 */
public class ConnectionToMySql {
    private static String path = "C:\\Users\\jdev\\IdeaProjects\\LabriaryPortal\\src\\main\\resources\\db_setting.properties";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/labriary";
    private static String user = "root";
    private static String password = "root";

    public static Connection createConnection() {
        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
