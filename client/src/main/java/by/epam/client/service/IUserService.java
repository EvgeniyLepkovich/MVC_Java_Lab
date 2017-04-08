package by.epam.client.service;

import by.epam.client.model.User;

import java.util.List;
import java.util.concurrent.Future;

public interface IUserService {
    User getUserById(Long id);
    Future<User> getUserByIdAsync(Long id) throws InterruptedException;
    void addUser(User user);
}
