package by.onlineStore.jdbcTemplate;

import by.onlineStore.bean.User;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
public interface UserRepository {
    User findById(Integer idUser);
    User getUserByName(String nameUser);
    List<User> getAllUsers();
    int deleteUser(Integer idUser);
    void updateUser(User user);
    void saveUser(User user);
}
