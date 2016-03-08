package ua.org.oa.atrotskov;

import ua.org.oa.atrotskov.model.dto.UserDTO;
import ua.org.oa.atrotskov.service.api.UserService;
import ua.org.oa.atrotskov.service.impl.UserServiceImpl;

/**
 * Created by Kovantonlenko on 11/20/2015.
 */
public class Main {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Misha");
        userDTO.setLogin("mish1");

        UserService userService = UserServiceImpl.getInstance();

        //userService.addUser(userDTO);

        /*UserDTO retUser = userService.getUserById(3);
        System.out.println(retUser.getId());
        System.out.println(retUser.getName());
        System.out.println(retUser.getLogin());*/
    }
}