package by.onlineStore.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateProviderDto {

    private Long id;

    @NotNull
    @Size(min = 3, max = 20,
            message = "Product name must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",
            message = "Product name must be alphanumeric with no spaces")
    private String name;

    @NotNull
    @Size(max = 40, message = "Your e-mail is too long")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String mail;

    @NotNull
    private String phone;

    private List<CreateProductDto> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CreateProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<CreateProductDto> products) {
        this.products = products;
    }
}
