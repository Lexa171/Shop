package by.onlineStore.Repository;

import by.onlineStore.bean.Product;
import by.onlineStore.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
public interface ProductRepository extends JpaRepository<Product,Long>{

}
