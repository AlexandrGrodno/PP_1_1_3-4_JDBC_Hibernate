package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try{
            Statement statement = Util.getConnection().createStatement();
                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (`id` INT NOT NULL  AUTO_INCREMENT," +
                    "`name` VARCHAR(45) NOT NULL," +
                    "`lastName` VARCHAR(45) NOT NULL," +
                    "`age` INT NOT NULL,PRIMARY KEY (`id`))");
            System.out.println("создал Т");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dropUsersTable() {
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS user");
            System.out.println(" удалена Т");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement statement = Util.getConnection().createStatement();
           // statement.executeUpdate("INSERT INTO `newschema`.`user` (`name`, `lastName`, `age`) " +
             //       "VALUES ('name', 'lastName', 'age');\n");
            statement.executeUpdate(String.format(("INSERT INTO user (name, lastName, age) VALUES ('%s', '%s', %d)"), name, lastName, age));
            System.out.println("сохранил Ю");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void removeUserById(long id) {
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM user WHERE (`id` = '1')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = Util.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userList.add(
                    new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4))
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = Util.getConnection().createStatement();

            statement.executeUpdate("DELETE FROM user");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
