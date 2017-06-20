package by.onlineStore.repository;

import by.onlineStore.bean.User;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
public interface UserRepositoryJDBC {
    User findById(Long idUser);
    User getUserByName(String nameUser);
    List<User> getAllUsers();
    void deleteUser(Long idUser);
    void updateUser(User user);
    void saveUser(User user);
}
