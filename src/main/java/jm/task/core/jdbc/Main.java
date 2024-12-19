package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.entity.UserEntity;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("Name5", "LastName5", (byte) 45);
        UserEntity user = userDao.getAllUsers().get(0);
        System.out.println(user);

    }
}
