package by.onlineStore.dto;

import by.onlineStore.bean.Product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Admin on 05.06.2017.
 */
public class ProductDto {
    private Long idProduct;
    @NotNull
    @Size(min = 3, max = 20,
            message = "Product name must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",
            message = "Product name must be alphanumeric with no spaces")
    private String nameProduct;
    @NotNull
    private Integer typeProduct;
    @NotNull
    private Integer priceProduct;
    @NotNull
    private String description;
    @NotNull
    private Integer quantity;
    @NotNull
    private Long idProvider;
    @NotNull
    private Integer evaluation;
    public ProductDto(){}
    public ProductDto(Product product){
        this.idProduct=product.getIdProduct();
        this.nameProduct=product.getNameProduct();
        this.typeProduct=product.getTypeProduct();
        this.priceProduct=product.getPriceProduct();
        this.description=product.getDescription();
        this.quantity=product.getQuantity();
        this.idProvider=product.getIdProvider();
        this.evaluation=product.getEvaluation();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Integer typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }
}
