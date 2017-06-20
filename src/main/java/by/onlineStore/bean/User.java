package by.onlineStore.bean;


import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "mail", length = 50, unique = true)
    private String mail;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "basket", catalog = "mybd", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id",
                    nullable = false, updatable = false)})
    private List<Product> products;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User() {
    }

    public User(Long id_user, String name_user, String mail_user) {
        id = id_user;
        name = name_user;
        mail = mail_user;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "User INFO [ID: " + id
                + ", Name: " + name + "]";
    }
}
