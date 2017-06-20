package by.onlineStore.repository;

import by.onlineStore.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findOneById(Long id);
}
