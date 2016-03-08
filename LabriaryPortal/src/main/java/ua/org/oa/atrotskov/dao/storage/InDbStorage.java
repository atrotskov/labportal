package ua.org.oa.atrotskov.dao.storage;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.api.ReportDAO;
import ua.org.oa.atrotskov.dao.connection.ConnectionToMySql;
import ua.org.oa.atrotskov.dao.api.UserDAO;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.Report;
import ua.org.oa.atrotskov.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jdev on 17.12.2015.
 */
public class InDbStorage implements UserDAO, BookDAO, ReportDAO {

    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_BIRTHDAY = "birthDay";
    public static final String USER_ADMIN = "is_admin";
    public static final String BOOK_ID = "id";
    public static final String BOOK_TITLE = "title";
    public static final String BOOK_AUTHOR = "author";
    public static final String BOOK_COUNT = "count";
    /* init Singleton InDbStorage */
    private static InDbStorage instance = new InDbStorage();
    private InDbStorage() {
    }
    public static InDbStorage getInstance(){
        return instance;
    }
    /* end of init Singleton */


    private void setUser(User user, ResultSet rs) throws SQLException {
        user.setId(rs.getLong(USER_ID));
        user.setName(rs.getString(USER_NAME));
        user.setLogin(rs.getString(USER_LOGIN));
        user.setPassword(rs.getString(USER_PASSWORD));
        user.setBirthday(rs.getDate(USER_BIRTHDAY));
        user.setAdmin(rs.getBoolean(USER_ADMIN));
    }

    private void doFinaly(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void doFinaly(Connection conn, PreparedStatement ps1, PreparedStatement ps2) {
        if (ps1 != null) {
            try {
                ps1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps2 != null) {
            try {
                ps2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void doFinaly(Connection conn, PreparedStatement ps1,
                          PreparedStatement ps2, PreparedStatement ps3) {
        if (ps1 != null) {
            try {
                ps1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps2 != null) {
            try {
                ps2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps3 != null) {
            try {
                ps3.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public long addUser(User user) {
        final String QUERY = "INSERT INTO user (name, login, password, birthDay, is_admin) VALUES (?,?,?,?,?)";
        long result = 0;
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setDate(4,(new java.sql.Date(user.getBirthday().getTime())));
            ps.setBoolean(5, false);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return result;
    }

    @Override
    public User getUserById(long id) {
        final String QUERY = "SELECT * FROM user WHERE id = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        User user = null;
        try {
            user = new User();
            ps = conn.prepareStatement(QUERY);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setUser(user, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        final String QUERY = "UPDATE user SET name = ?, login = ?, password = ?, birthDay = ?, is_admin = ? WHERE id = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setDate(4, (java.sql.Date) user.getBirthday());
            ps.setBoolean(5, user.getAdmin());
            ps.setLong(6, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return true;
    }

    @Override
    public boolean deleteUserById(long id) {
        final String QUERY = "DELETE FROM user WHERE id = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return true;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        final String QUERY = "SELECT * FROM user";
        ArrayList<User> users = new ArrayList<>();
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                setUser(user, rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return users;
    }

    @Override
    public boolean isLoginExist(User user) {
        final String QUERY = "SELECT COUNT(*) AS res FROM user WHERE login = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        boolean result = false;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setString(1, user.getLogin());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt("res");
            System.out.println(count);
            if (count > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return result;
    }

    @Override
    public boolean doUserTakeBook(long userId, long bookId) {
        final String QUERY_SELECT = "SELECT count FROM book WHERE id = ?";
        final String QUERY_UPDATE = "UPDATE book SET count = count - 1 WHERE id = ?";
        final String QUERY_INSERT = "INSERT INTO relation (user_id, book_id) VALUES (?,?)";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psInsert = null;
        try {
            conn.setAutoCommit(false);
            psSelect = conn.prepareStatement(QUERY_SELECT);
            psSelect.setLong(1, bookId);
            ResultSet rs = psSelect.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                throw new SQLException("This book is not available at the moment");
            }
            psUpdate = conn.prepareStatement(QUERY_UPDATE);
            psUpdate.setLong(1, bookId);
            psUpdate.executeUpdate();
            psInsert = conn.prepareStatement(QUERY_INSERT);
            psInsert.setLong(1, userId);
            psInsert.setLong(2, bookId);
            psInsert.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            doFinaly(conn, psInsert, psSelect, psUpdate);
        }
        return false;
    }

    @Override
    public boolean doUserReturnBook(long userId, long bookId) {
        final String QUERY_UPDATE = "UPDATE book SET count = count + 1 WHERE id = ?";
        final String QUERY_DELETE = "DELETE FROM relation WHERE (user_id = ? AND book_id = ?)";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement psUpdate = null;
        PreparedStatement psDelete = null;
        try {
            conn.setAutoCommit(false);
            psUpdate = conn.prepareStatement(QUERY_UPDATE);
            psUpdate.setLong(1, bookId);
            psUpdate.executeUpdate();
            psDelete = conn.prepareStatement(QUERY_DELETE);
            psDelete.setLong(1, userId);
            psDelete.setLong(2, bookId);
            psDelete.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            doFinaly(conn, psUpdate, psDelete);
        }
        return true;
    }

    @Override
    public boolean isUserHaveThisBook(long userId, long bookId) {
        final String QUERY = "SELECT * FROM relation WHERE (user_id = ? AND book_id = ?)";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        boolean resault = false;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setLong(1, userId);
            ps.setLong(2, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resault = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return resault;
    }

    @Override
    public ArrayList<User> getUsersByName(String name) {
        ArrayList<User> users = new ArrayList<>();
        final String QUERY = "SELECT * FROM user WHERE name = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps= null;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                setUser(user, rs);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return users;
    }

    @Override
    public User getUserByLogin(String login) {
        final String QUERY = "SELECT * FROM user WHERE login = ?";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        User user = new User();
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                setUser(user, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return user;
    }

    @Override
    public ArrayList<User> getUsersByBirthday(Date date) {
        return null;
    }

    @Override
    public ArrayList<User> getUsersByReadBook(Book book) {
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        final String QUERY = "INSERT INTO book (title, author, count) VALUES (?,?,?)";
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        boolean result = false;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCount());
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn,ps);
        }
        return result;
    }

    @Override
    public Book getBookById(long id) {
        final String QUERY = "SELECT * FROM book WHERE id = ?";
        Connection conn = ConnectionToMySql.createConnection();
        Book book = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setBook(book, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return book;
    }

    private void setBook(Book book, ResultSet rs) throws SQLException {
        book.setId(rs.getLong(BOOK_ID));
        book.setTitle(rs.getString(BOOK_TITLE));
        book.setAuthor(rs.getString(BOOK_AUTHOR));
        book.setCount(rs.getInt(BOOK_COUNT));
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBookById(long id) {
        return false;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        final String QUERY = "SELECT * FROM book";
        ArrayList<Book> books = new ArrayList<>();
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                setBook(book, rs);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return books;
    }

    @Override
    public ArrayList<Book> getBooksByTitle(String title) {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksByAuthor(String author) {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksByUser(User user) {
        final String QUERY = "SELECT id, title, author, count FROM book WHERE id IN (SELECT book_id FROM relation WHERE user_id = ?)";
        ArrayList<Book> books = new ArrayList<>();
        Connection conn = ConnectionToMySql.createConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(QUERY);
            long id = user.getId();
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                setBook(book, rs);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            doFinaly(conn, ps);
        }
        return books;
    }

    @Override
    public boolean addReport(Report report) {
        return false;
    }

    @Override
    public Report getReportById(long id) {
        return null;
    }

    @Override
    public boolean updateReport(Report report) {
        return false;
    }

    @Override
    public boolean deleteReportById(long id) {
        return false;
    }

    @Override
    public ArrayList<Report> getReportsByDate(java.util.Date date) {
        return null;
    }

    @Override
    public ArrayList<Report> getReportsByUser(User user) {
        return null;
    }

    @Override
    public ArrayList<Report> getReportsByBook(Book book) {
        return null;
    }
}
