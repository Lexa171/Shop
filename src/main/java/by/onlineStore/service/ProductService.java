package by.onlineStore.service;

import by.onlineStore.bean.Product;

import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
public interface ProductService {
    Product getUserById(Long productId);
    List<Product> getAllProduct();
    void deleteProduct(Long productId);
    void saveOrUpdateProduct(Product product);
}
