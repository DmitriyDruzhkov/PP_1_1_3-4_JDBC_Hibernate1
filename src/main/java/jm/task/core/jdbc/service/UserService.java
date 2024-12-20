package jm.task.core.jdbc.service;

import jm.task.core.jdbc.entity.UserEntity;

import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<UserEntity> getAllUsers();

    void cleanUsersTable();
}
