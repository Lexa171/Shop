package by.onlineStore.mapper;

import by.onlineStore.bean.Product;
import by.onlineStore.bean.Provider;
import by.onlineStore.dto.CreateProductDto;
import by.onlineStore.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    public Product convertToProduct(CreateProductDto createProductDto, Provider  provider) {

        return Optional.of(createProductDto).map(localCreateProductDto -> {
            Product product = new Product();
            product.setName(localCreateProductDto.getNameProduct());
            product.setType(localCreateProductDto.getTypeProduct());
            product.setPrice(localCreateProductDto.getPriceProduct());
            product.setDescription(localCreateProductDto.getDescription());
            product.setQuantity(localCreateProductDto.getQuantity());
            product.setProvider(provider);
            product.setEvaluation(localCreateProductDto.getEvaluation());
            return product;
        }).orElse(null);
    }

    public ProductDto convertToProductDto(Product product) {

        return Optional.of(product).map(localProduct -> {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(localProduct.getId());
            productDto.setNameProduct(localProduct.getName());
            productDto.setTypeProduct(localProduct.getType());
            productDto.setPriceProduct(localProduct.getPrice());
            productDto.setDescription(localProduct.getDescription());
            productDto.setQuantity(localProduct.getQuantity());
            productDto.setProviderId(localProduct.getProvider().getId());
            productDto.setEvaluation(localProduct.getEvaluation());
            productDto.setUsers(userMapper.convertToListUserDto(localProduct.getUsers()));
            productDto.setComments(commentMapper.convertToListCommentDto(localProduct.getComments()));
            return productDto;
        }).orElse(null);
    }

    public List<ProductDto> convertToListProductDto(List<Product> productList) {

        return Optional.ofNullable(productList).map(localProductList ->
                localProductList.stream()
                        .map(this::convertToProductDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public Product convertToProduct(ProductDto productDto, Provider  provider) {

        return Optional.of(productDto).map(localProductDto -> {
            Product product = new Product();
            product.setId(localProductDto.getProductId());
            product.setName(localProductDto.getNameProduct());
            product.setType(localProductDto.getTypeProduct());
            product.setPrice(localProductDto.getPriceProduct());
            product.setDescription(localProductDto.getDescription());
            product.setQuantity(localProductDto.getQuantity());
            product.setProvider(provider);
            product.setEvaluation(localProductDto.getEvaluation());
            return product;
        }).orElse(null);
    }
}
