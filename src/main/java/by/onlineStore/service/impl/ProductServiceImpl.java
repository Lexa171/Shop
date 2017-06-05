package by.onlineStore.service.impl;

import by.onlineStore.Repository.ProductRepository;
import by.onlineStore.bean.Product;
import by.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 05.06.2017.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getUserById(Long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.delete(productId);
    }

    @Override
    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }
}
