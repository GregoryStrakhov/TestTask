package by.gregory.crud.service;

import by.gregory.crud.model.User;

import java.util.List;

/**
 * Created by User1 on 24.01.2017.
 */
public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public User getUserByName (String userName);



    public List<User> listUsers();
}
