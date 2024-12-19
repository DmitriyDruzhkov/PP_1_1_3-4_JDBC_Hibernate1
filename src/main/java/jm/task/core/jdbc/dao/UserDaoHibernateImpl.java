package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.entity.UserEntity;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNativeQuery("CREATE TABLE `mydbtest`.`user` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNativeQuery("DROP TABLE IF EXISTS user");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        UserEntity user = new UserEntity(name, lastName, age);
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity user = session.get(UserEntity.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserEntity> users = session.createQuery("from UserEntity").list();
        transaction.commit();
        session.close();
        return users;

    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from UserEntity").executeUpdate();
        transaction.commit();
        session.close();
    }
}
