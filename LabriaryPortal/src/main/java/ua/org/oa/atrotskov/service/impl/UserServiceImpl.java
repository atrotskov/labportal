package ua.org.oa.atrotskov.service.impl;

import ua.org.oa.atrotskov.dao.fetch.FetchDAO;
import ua.org.oa.atrotskov.dao.api.UserDAO;
import ua.org.oa.atrotskov.model.dto.BookDTO;
import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.model.entity.User;
import ua.org.oa.atrotskov.service.api.UserService;
import ua.org.oa.atrotskov.transform.Transformer;

import java.util.ArrayList;

/**
 * Created by Kovantonlenko on 11/20/2015.
 */
public class UserServiceImpl implements UserService {
    // Init Singleton UserService Begin
    private static UserService userService;
    private UserServiceImpl() {
    }

    public synchronized static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
    // Init Singleton UserService End

    private UserDAO userDAO = FetchDAO.fetchUserDao();

    @Override
    public UserDTO getUserById(long id) {
        User userById = userDAO.getUserById(id);
        return Transformer.transformUser(userById);
    }

    @Override
    public long addUser(UserDTO userDTO) {
        User user = Transformer.transformUserDTO(userDTO);
        return userDAO.addUser(user);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        User user = Transformer.transformUserDTO(userDTO);
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        User user = Transformer.transformUserDTO(userDTO);
        return userDAO.deleteUserById(user.getId());
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        ArrayList<User> users = userDAO.getAllUsers();
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(Transformer.transformUser(user));
        }
        return usersDTO;
    }

    @Override
    public boolean isLoginExist(UserDTO userDTO) {
        User user = Transformer.transformUserDTO(userDTO);
        return userDAO.isLoginExist(user);
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        return Transformer.transformUser(userDAO.getUserByLogin(login));
    }

    @Override
    public boolean doUserTakeBook(long userId, long bookId) {
        return userDAO.doUserTakeBook(userId, bookId);
    }

    @Override
    public boolean doUserReturnBook(long userId, long bookId) {
        return userDAO.doUserReturnBook(userId, bookId);
    }

    @Override
    public boolean isUserHaveThisBook(long userId, long bookId) {
        return  userDAO.isUserHaveThisBook(userId, bookId);
    }


}
