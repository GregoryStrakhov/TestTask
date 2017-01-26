package by.gregory.crud.service;

import by.gregory.crud.dao.UserDao;
import by.gregory.crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User1 on 24.01.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Transactional
    @Override
    public User getUserByName(String userName) {
        return this.userDao.getUserByName(userName);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
