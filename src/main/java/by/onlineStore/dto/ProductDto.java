package by.onlineStore.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


public class ProductDto {

    @NotNull
    private Long productId;

    @Size(min = 3, max = 20,
            message = "Product name must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",
            message = "Product name must be alphanumeric with no spaces")
    private String nameProduct;

    private Integer typeProduct;

    private Integer priceProduct;

    private String description;

    private Integer quantity;

    private Long providerId;

    private Integer evaluation;

    private List<UserDto> users;

    private List<CommentDto> comments;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}


