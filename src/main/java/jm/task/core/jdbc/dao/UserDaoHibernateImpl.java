package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import org.hibernate.*;
import jakarta.persistence.*;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory = Util.getConnectionHibernate();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session. createQuery("CREATE TABLE IF NOT EXISTS user " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), " +
                    "lastName VARCHAR(45), age TINYINT)").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        //close();


    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        try{ session.beginTransaction();
        session.createQuery("DROP TABLE IF EXISTS user").executeUpdate();
        session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
        session.close();}
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.printf("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        session.persist(new User(name,lastName,age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
