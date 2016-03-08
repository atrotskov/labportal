package ua.org.oa.atrotskov.dao.impl;

import ua.org.oa.atrotskov.dao.api.BookDAO;
import ua.org.oa.atrotskov.dao.api.ReportDAO;
import ua.org.oa.atrotskov.dao.api.UserDAO;
import ua.org.oa.atrotskov.dao.storage.InMemoryStorage;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.Report;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by jdev on 17.12.2015.
 */
public class UserDaoMemoryImpl implements UserDAO {
    private static UserDAO userDAO;
    private InMemoryStorage instance = InMemoryStorage.getInstance();

    private UserDaoMemoryImpl() {
    }

    public synchronized static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDaoMemoryImpl();
        }
        return userDAO;
    }


    @Override
    public long addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUserById(long id) {
        return false;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean isLoginExist(User user) {
        return false;
    }

    @Override
    public boolean doUserTakeBook(long userId, long bookId) {
        return false;
    }

    @Override
    public boolean doUserReturnBook(long userId, long bookId) {
        return false;
    }

    @Override
    public boolean isUserHaveThisBook(long userId, long bookId) {
        return false;
    }


    @Override
    public ArrayList<User> getUsersByName(String name) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public ArrayList<User> getUsersByBirthday(Date date) {
        return null;
    }

    @Override
    public ArrayList<User> getUsersByReadBook(Book book) {
        return null;
    }
}
