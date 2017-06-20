package by.onlineStore.repository.jdbcImpl;

import by.onlineStore.repository.ProductRepositoryJDBC;
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

@Transactional
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepositoryJDBC {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryJDBC.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper ROW_MAPPER = (RowMapper<Product>) (resultSet, i) ->
            new Product(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getInt("price"));

    @Override
    public Product findById(Long idProduct) {
        Product product = null;
        try {
            product = (Product) jdbcTemplate.queryForObject("select * from product where id = ?",
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
            product = (Product) jdbcTemplate.queryForObject("select * from product where name = ?",
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
        jdbcTemplate.update("delete from product where id = ?", idProduct);
    }

    @Override
    public void updateProduct(Product product) {
        try {
            jdbcTemplate.update("update product set name = ?, type = ?, price = ?," +
                            "description = ?, quantity = ?, provider_id = ?, evaluation = ? where id = ?",
                    product.getName(), product.getType(), product.getPrice(), product.getDescription(),
                    product.getQuantity(), product.getProvider(), product.getEvaluation(), product.getId());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't update entity of type Product with id {}", product.getId());
        }
    }

    @Override
    public void saveProduct(Product product) {
        try {
            jdbcTemplate.update("insert into product values (?,?, ?, ?, ?, ?, ?, ?)",
                    product.getId(), product.getName(), product.getType(), product.getPrice(),
                    product.getDescription(), product.getQuantity(), product.getProvider(), product.getEvaluation());
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't save entity of type Product with id {}", product.getId());
        }
    }
}
