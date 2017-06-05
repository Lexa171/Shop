package by.onlineStore.Repository.jdbcImpl;

import by.onlineStore.Repository.UserRepositoryJDBC;
import by.onlineStore.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
@Transactional
@Repository( "userRepository")
public class UserRepositoryImpl implements UserRepositoryJDBC {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryJDBC.class);
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    private RowMapper ROW_MAPPER = (RowMapper<User>) (resultSet, i) ->
            new User(resultSet.getLong("id_User"), resultSet.getString("name_User"),
                    resultSet.getString("mail_User"));

    public UserRepositoryImpl(){}
    @Override
    public User findById(Long idUser) {
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject("select * from user where id_User = ?", new Object[]{idUser}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type User with id {}", idUser);
        }

        return user;
    }

    @Override
    public User getUserByName(String nameUser) {
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject("select * from user where name_User = ?", new Object[]{nameUser},
                    ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type User with name {}", nameUser);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", ROW_MAPPER);
    }

    @Override
    public void deleteUser(Long idUser) {
        jdbcTemplate.update("delete from user where id_User = ?", idUser);
    }

    @Override
    public void updateUser(User user) {
        try {
        jdbcTemplate.update("update user set name_User = ?, password = ?, mail_User = ?  where id_User = ?",
                user.getNameUser(), user.getPassword(), user.getMailUser(), user.getIdUser());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't update entity of type User with id {}", user.getIdUser());
        }
    }

    @Override
    public void saveUser(User user) {
        try {jdbcTemplate.update("insert into user values (?, ?, ?, ?)", user.getIdUser(),user.getNameUser(),
                user.getMailUser(),user.getPassword());
    } catch (DataAccessException dataAccessException) {
        LOGGER.debug("Couldn't save entity of type User with id {}", user.getIdUser());
    }
    }
}
