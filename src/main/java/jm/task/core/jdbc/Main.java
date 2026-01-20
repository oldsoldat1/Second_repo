package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        UserService userService = new UserServiceImpl();

        try {
           userService.createUsersTable();

           userService.saveUser("Alex", "Sidorov", (byte) 35);
           userService.saveUser("Alla", "Duhova", (byte) 23);
           userService.saveUser("Ivan", "Popov", (byte) 31);
           userService.saveUser("Elena", "Petrova", (byte) 15);

           List<User> users = userService.getAllUsers();
            System.out.println("Все пользователи из базы");
            for (User user: users) {
                System.out.println(user);
            }

            userService.cleanUsersTable();

            userService.dropUsersTable();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
