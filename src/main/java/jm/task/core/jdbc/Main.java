package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util util = new Util();

        util.getConnection();
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("INSERT INTO `newschema`.`new_table` (`name`, `secondName`, `age`) VALUES ('44', '555', '3');\n");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM new_table");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
               String secondName = resultSet.getString(3);
               int age = resultSet.getInt(4);
                System.out.println(id +" "+ name+" "  +secondName+" "+ age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
