package by.onlineStore.bean;

/**
 * Created by Admin on 14.05.2017.
 */
public class Product {
    private Integer idProduct;
    private String nameProduct;
    private Integer typeProduct;
    private Integer priceProduct;
    private String description;
    private Integer quantity;
    private Integer idProvider;
    private Integer evaluation;
    public Product(){}

    public Product(Integer id_product, String name_product, Integer price_product) {
       idProduct=id_product;
       nameProduct=name_product;
       priceProduct=price_product;
    }

    public Product(Integer id_product, String name_product, Integer  type_Product, Integer price_product, String description,
                   Integer quantity, Integer id_Provider, Integer evaluation) {
        idProduct=id_product;
        nameProduct=name_product;
        typeProduct=type_Product;
        priceProduct=price_product;
        this.description=description;
        this.quantity=quantity;
        idProvider=id_Provider;
        this.evaluation=evaluation;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
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

    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
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
