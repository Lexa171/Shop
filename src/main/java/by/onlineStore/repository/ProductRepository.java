package by.onlineStore.repository;

import by.onlineStore.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long>{
    Optional<Product> findOneById(Long id);

}
