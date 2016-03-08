package ua.org.oa.atrotskov.dao.impl;

import ua.org.oa.atrotskov.dao.api.UserDAO;
import ua.org.oa.atrotskov.dao.storage.InDbStorage;
import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jdev on 17.12.2015.
 */
public class UserDaoDbImpl implements UserDAO {

    private InDbStorage instance = InDbStorage.getInstance();

    private static UserDAO userDAO;

    private UserDaoDbImpl() {
    }

    public synchronized static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDaoDbImpl();
        }
        return userDAO;
    }


    @Override
    public long addUser(User user) {
        return instance.addUser(user);
    }

    @Override
    public User getUserById(long id) {
        return instance.getUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        instance.updateUser(user);
        return true;
    }

    @Override
    public boolean deleteUserById(long id) {
        instance.deleteUserById(id);
        return true;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return instance.getAllUsers();
    }

    @Override
    public boolean isLoginExist(User user) {
        return instance.isLoginExist(user);
    }

    @Override
    public boolean doUserTakeBook(long userId, long bookId) {
        return instance.doUserTakeBook(userId, bookId);
    }

    @Override
    public boolean doUserReturnBook(long userId, long bookId) {
        return instance.doUserReturnBook(userId, bookId);
    }


    @Override
    public boolean isUserHaveThisBook(long userId, long bookId) {
        return instance.isUserHaveThisBook(userId, bookId);
    }


    @Override
    public ArrayList<User> getUsersByName(String name) {
        return instance.getUsersByName(name);
    }

    @Override
    public User getUserByLogin(String login) {
        return instance.getUserByLogin(login);
    }

    @Override
    public ArrayList<User> getUsersByBirthday(Date date) {
        return instance.getUsersByBirthday(date);
    }

    @Override
    public ArrayList<User> getUsersByReadBook(Book book) {
        return instance.getUsersByReadBook(book);
    }
}
