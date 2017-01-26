package by.gregory.crud.dao;

import by.gregory.crud.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);

        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (User) session.load(User.class, id);
    }

    @Override
    public User getUserByName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return (User) session.load(User.class, userName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();

        return (List<User>) session.createQuery("from User").list();
    }
}
