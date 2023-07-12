package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

       UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
       User user1 = new User("Ivan","Ivanov", (byte) 10);
//        User user2 = new User("Petr","Petrov", (byte) 11);
//        User user3 = new User("Lesha","Leshin", (byte) 12);
//        User user4 = new User("Masha","Mashkova", (byte) 13);
//
//

        //System.out.println(userService.getAllUsers());
        userService.createUsersTable();
        //userService.saveUser("asd","asdsad",(byte) 12);


    }
}
