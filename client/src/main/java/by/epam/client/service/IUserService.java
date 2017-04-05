package by.epam.client.service;

import by.epam.client.model.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getUsersById(Long[] ids);
    void addUser(User user);
}
