package by.epam.client.service.impl;

import by.epam.client.dao.impl.UserDao;
import by.epam.client.model.User;
import by.epam.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsersById(Long[] ids) {
        return userDao.getUsersById(ids);
    }

    @Override
    public void addUser(User user) {
        userDao.AddUser(user);
    }
}
