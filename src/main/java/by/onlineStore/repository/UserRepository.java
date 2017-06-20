package by.onlineStore.repository;

import by.onlineStore.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Admin on 10.05.2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneById(Long id);

}
