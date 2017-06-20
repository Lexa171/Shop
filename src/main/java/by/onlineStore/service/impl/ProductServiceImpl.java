package by.onlineStore.service.impl;

import by.onlineStore.repository.ProductRepository;
import by.onlineStore.repository.ProviderRepository;
import by.onlineStore.dto.CreateProductDto;
import by.onlineStore.dto.ProductDto;
import by.onlineStore.exception.NotFoundException;
import by.onlineStore.mapper.ProductMapper;
import by.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public ProductDto getProductById(Long productId) {
        return productMapper.convertToProductDto(productRepository.findOneById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found")));
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return productMapper.convertToListProductDto(productRepository.findAll());
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.delete(productId);
    }

    @Override
    public ProductDto saveProduct(CreateProductDto createProductDto) {
        return productMapper.convertToProductDto(productRepository.saveAndFlush
                (productMapper.convertToProduct(createProductDto,
                        providerRepository.findOneById(createProductDto.getProviderId())
                                .orElseThrow(() -> new NotFoundException("Provider not found")))));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productMapper.convertToProductDto(productRepository.saveAndFlush(
                productMapper.convertToProduct(productDto,
                        providerRepository.findOneById(productDto.getProviderId())
                        .orElseThrow(() -> new NotFoundException("Provider not found")))));
    }
}
