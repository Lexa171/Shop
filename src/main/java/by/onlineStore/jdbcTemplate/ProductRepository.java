package by.onlineStore.jdbcTemplate;

import by.onlineStore.bean.Product;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
public interface ProductRepository {
    Product findById(Integer idProduct);
    Product getProductByName(String nameProduct);
    List<Product> getAllProduct();
    int deleteProduct(Integer idProduct);
    void updateProduct(Product product);
    void saveProduct(Product product);
}
