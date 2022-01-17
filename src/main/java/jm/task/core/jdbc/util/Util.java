package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    Connection connection;

    public Util(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydbtest";
        String username = "root";
        String password = "ramones1988";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        return connection;
    }
    // реализуйте настройку соеденения с БД
}
