package by.onlineStore.Repository.jdbcImpl;

import by.onlineStore.Repository.ProductRepositoryJDBC;
import by.onlineStore.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
@Transactional
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepositoryJDBC {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryJDBC.class);
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    private RowMapper ROW_MAPPER = (RowMapper<Product>) (resultSet, i) ->
            new Product(resultSet.getLong("id_Product"), resultSet.getString("name_Product"),
                    resultSet.getInt("price_Product"));

    public ProductRepositoryImpl() {
    }

    @Override
    public Product findById(Long idProduct) {
        Product product = null;
        try {
            product = (Product) jdbcTemplate.queryForObject("select * from product where id_Product = ?",
                    new Object[]{idProduct}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Product with id {}", idProduct);
        }

        return product;
    }

    @Override
    public Product getProductByName(String nameProduct) {
        Product product = null;
        try {
            product = (Product) jdbcTemplate.queryForObject("select * from product where name_Product = ?",
                    new Object[]{nameProduct}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Product with name {}", nameProduct);
        }

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return jdbcTemplate.query("select * from product", ROW_MAPPER);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        jdbcTemplate.update("delete from product where id_Product = ?", idProduct);
    }

    @Override
    public void updateProduct(Product product) {
        try {
            jdbcTemplate.update("update product set name_Product= ?, type_Product= ?, price_Product= ?," +
                            "description= ?, quantity= ?, id_Provider= ?, evaluation= ? where id_Product = ?",
                    product.getNameProduct(), product.getTypeProduct(), product.getPriceProduct(), product.getDescription(),
                    product.getQuantity(), product.getIdProvider(), product.getEvaluation(),product.getIdProduct());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't update entity of type Product with id {}", product.getIdProduct());
        }
    }

    @Override
    public void saveProduct(Product product) {
        try {
            jdbcTemplate.update("insert into product values (?,?, ?, ?, ?, ?, ?, ?)",
                    product.getIdProduct(), product.getNameProduct(), product.getTypeProduct(), product.getPriceProduct(),
                    product.getDescription(), product.getQuantity(), product.getIdProvider(), product.getEvaluation());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't save entity of type Product with id {}", product.getIdProduct());
        }
    }
}
