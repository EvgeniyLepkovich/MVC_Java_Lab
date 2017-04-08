package by.epam.client.service.impl;

import by.epam.client.dao.impl.UserDao;
import by.epam.client.model.User;
import by.epam.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Async
    @Override
    public Future<User> getUserByIdAsync(Long id) throws InterruptedException {
        User user = userDao.getUserById(id);
        return new AsyncResult<>(user);
    }

    @Override
    public void addUser(User user) {
        userDao.AddUser(user);
    }
}
