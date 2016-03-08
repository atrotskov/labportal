package ua.org.oa.atrotskov.dao.api;

import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kovantonlenko on 11/20/2015.
 */

public interface UserDAO {
    public long addUser(User user);
    public User getUserById(long id);
    public boolean updateUser(User user);
    public boolean deleteUserById(long id);
    public ArrayList<User> getAllUsers();
    public boolean isLoginExist(User user);
    public boolean doUserTakeBook(long userId, long bookId);
    public boolean doUserReturnBook(long userId, long bookId);
    public boolean isUserHaveThisBook(long userId, long bookId);

    public User getUserByLogin(String login);
    public ArrayList<User> getUsersByName(String name);
    public ArrayList<User> getUsersByBirthday(Date date);
    public ArrayList<User> getUsersByReadBook(Book book);
}
