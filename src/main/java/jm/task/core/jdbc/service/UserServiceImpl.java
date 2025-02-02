package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao1 = new UserDaoHibernateImpl();
    UserDao userDao = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDao1.createUsersTable();
    }

    public void dropUsersTable() {
        userDao1.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao1.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {

        return  userDao.getAllUsers();
    }

    public void cleanUsersTable() {

        userDao.cleanUsersTable();
    }
}
