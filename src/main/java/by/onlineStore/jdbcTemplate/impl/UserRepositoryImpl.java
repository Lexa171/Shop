package by.onlineStore.jdbcTemplate.impl;

import by.onlineStore.bean.User;
import by.onlineStore.jdbcTemplate.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
@Repository( "userRepository")
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    private RowMapper ROW_MAPPER = (RowMapper<User>) (resultSet, i) ->
            new User(resultSet.getInt("id_User"), resultSet.getString("name_User"),
                    resultSet.getString("mail_User"));
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public User findById(Integer idUser) {
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject("select * from user where id_User = ?", new Object[]{idUser}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type User with id {}", idUser);
        }

        return user;
    }

    @Override
    @Transactional
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
    @Transactional
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", ROW_MAPPER);
    }

    @Override
    @Transactional
    public int deleteUser(Integer idUser) {
        return jdbcTemplate.update("delete from user where id_User = ?", idUser);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        try {
        jdbcTemplate.update("update user set name_User = ?, password = ?, mail_User = ?  where id_User = ?",
                user.getNameUser(), user.getPassword(), user.getMailUser(), user.getIdUser());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't update entity of type User with id {}", user.getIdUser());
        }
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        try {jdbcTemplate.update("insert into user values (?, ?, ?, ?)", user.getIdUser(),user.getNameUser(),
                user.getMailUser(),user.getPassword());
    } catch (DataAccessException dataAccessException) {
        LOGGER.debug("Couldn't save entity of type User with id {}", user.getIdUser());
    }
    }
}
