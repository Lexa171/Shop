package by.onlineStore.repository.jdbcImpl;

import by.onlineStore.repository.UserRepositoryJDBC;
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

@Transactional
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepositoryJDBC {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryJDBC.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper ROW_MAPPER = (RowMapper<User>) (resultSet, i) ->
            new User(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getString("mail"));

    @Override
    public User findById(Long idUser) {
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject("select * from user where id = ?",
                    new Object[]{idUser}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type User with id {}", idUser);
        }

        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject("select * from user where name = ?", new Object[]{name},
                    ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type User with name {}", name);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", ROW_MAPPER);
    }

    @Override
    public void deleteUser(Long id) {
        jdbcTemplate.update("delete from user where id = ?", id);
    }

    @Override
    public void updateUser(User user) {
        try {
            jdbcTemplate.update("update user set name = ?, password = ?, mail= ?  where id = ?",
                    user.getName(), user.getPassword(), user.getMail(), user.getId());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't update entity of type User with id {}", user.getId());
        }
    }

    @Override
    public void saveUser(User user) {
        try {
            jdbcTemplate.update("insert into user values (?, ?, ?, ?)", user.getId(), user.getName(),
                    user.getMail(), user.getPassword());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't save entity of type User with id {}", user.getId());
        }
    }
}
