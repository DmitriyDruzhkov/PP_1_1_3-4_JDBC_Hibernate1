package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.entity.UserEntity;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE `mydbtest`.`user` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE `mydbtest`.`user`;";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?);";
        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM user WHERE id = ?;";
        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserEntity> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT name, lastName, age FROM user";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                byte age = resultSet.getByte("age");
//                User user = new User(name, lastName, age);
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
        return null;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM `mydbtest`.`user`;";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

