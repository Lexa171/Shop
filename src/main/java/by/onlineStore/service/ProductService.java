package by.onlineStore.service;

import by.onlineStore.dto.CreateProductDto;
import by.onlineStore.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();

    void deleteProduct(Long productId);

    ProductDto saveProduct(CreateProductDto createProductDto);

    ProductDto updateProduct(ProductDto productDto);
}
