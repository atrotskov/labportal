package ua.org.oa.atrotskov.service.api;

import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.model.dto.UserDTO;

import java.util.ArrayList;

/**
 * Created by Kovantonlenko on 11/20/2015.
 */
public interface UserService {

    public UserDTO getUserById(long id);
    public long addUser(UserDTO userDTO);
    public boolean updateUser(UserDTO userDTO);
    public boolean deleteUser(UserDTO userDTO);
    public ArrayList<UserDTO> getAllUsers();
    public boolean isLoginExist(UserDTO userDTO);
    public UserDTO getUserByLogin(String login);
    public boolean doUserTakeBook(long userId, long bookId);
    public boolean doUserReturnBook(long userId, long bookId);
    public boolean isUserHaveThisBook(long userId, long bookId);
}
