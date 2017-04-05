package by.epam.client.dao.impl;

import by.epam.client.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    private Map<Long, User> users = new HashMap<Long, User>();

    protected UserDao(){
        users.put(new Long(1), new User("Alex", "Dubrov", 21));
        users.put(new Long(2), new User("Sam", "Vinchester", 22));
        users.put(new Long(3), new User("Din", "Vinchester", 25));
        users.put(new Long(4), new User("Maikl", "Jordan", 19));
        users.put(new Long(5), new User("Bob", "Makkarti", 33));
    }

    public User getUserById(Long id){
        return users.get(id);
    }

    public List<User> getUsersById(Long[] ids){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++){
            userList.add(users.get(ids[i]));
        }
        return userList;
    }

    public void AddUser(User user){
        users.put(Long.valueOf(users.keySet().size()), user);
    }
}
