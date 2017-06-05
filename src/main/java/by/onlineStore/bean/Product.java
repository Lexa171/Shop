package by.onlineStore.bean;

import by.onlineStore.dto.ProductDto;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Admin on 14.05.2017.
 */
@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(columnNames = "name_Product") })
public class Product{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_Product", unique = true, nullable = false)
    private Long idProduct;
    @Column(name = "name_Product", unique = true, nullable = false, length = 20)
    private String nameProduct;
    @Column(name = "type_Product", nullable = false)
    private Integer typeProduct;
    @Column(name = "price_Product", nullable = false)
    private Integer priceProduct;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "id_Provider", nullable = false)
    private Long idProvider;
    @Column(name = "evaluation", nullable = false)
    private Integer evaluation;
    public Product(){}

    public Product(Long id_product, String name_product, Integer price_product) {
       idProduct=id_product;
       nameProduct=name_product;
       priceProduct=price_product;
    }

    public Product(Long id_product, String name_product, Integer  type_Product, Integer price_product, String description,
                   Integer quantity, Long id_Provider, Integer evaluation) {
        idProduct=id_product;
        nameProduct=name_product;
        typeProduct=type_Product;
        priceProduct=price_product;
        this.description=description;
        this.quantity=quantity;
        idProvider=id_Provider;
        this.evaluation=evaluation;
    }
    public Product(ProductDto productDto){
        this.idProduct=productDto.getIdProduct();
        this.nameProduct=productDto.getNameProduct();
        this.typeProduct=productDto.getTypeProduct();
        this.priceProduct=productDto.getPriceProduct();
        this.description=productDto.getDescription();
        this.quantity=productDto.getQuantity();
        this.idProvider=productDto.getIdProvider();
        this.evaluation=productDto.getEvaluation();
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
    @Override
    public String toString() {
        return "Product INFO [ID: " + idProduct + ", Name: " + nameProduct + "]";
    }
}
