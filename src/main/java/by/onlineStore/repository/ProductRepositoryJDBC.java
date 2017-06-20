package by.onlineStore.repository;

import by.onlineStore.bean.Product;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
public interface ProductRepositoryJDBC{
   Product findById(Long idProduct);
    Product getProductByName(String nameProduct);
    List<Product> getAllProduct();
    void deleteProduct(Long idProduct);
    void updateProduct(Product product);
    void saveProduct(Product product);
}
