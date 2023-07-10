package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        User user1 = new User("Ivan","Ivanov", (byte) 10);
        User user2 = new User("Petr","Petrov", (byte) 11);
        User user3 = new User("Lesha","Leshin", (byte) 12);
        User user4 = new User("Masha","Mashkova", (byte) 13);
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        userService.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        userService.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
        userService.saveUser(user4.getName(),user4.getLastName(),user4.getAge());



    }
}
