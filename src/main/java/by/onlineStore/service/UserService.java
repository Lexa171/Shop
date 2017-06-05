package by.onlineStore.service;

import by.onlineStore.bean.User;

import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    void saveOrUpdateUser(User user);
}
