package by.onlineStore;

import by.onlineStore.bean.Product;
import by.onlineStore.bean.User;
import by.onlineStore.jdbcTemplate.ProductRepository;
import by.onlineStore.jdbcTemplate.UserRepository;
import by.onlineStore.jdbcTemplate.impl.ProductRepositoryImpl;
import by.onlineStore.jdbcTemplate.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Admin on 10.05.2017.
 */
@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/
}

/*private void now(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
        User user = new User(5, "4", "1", "1");

        System.out.println(userRepository.getUserByName("4"));
       *//* ProductRepository productRepository =  (ProductRepository) context.getBean("productRepository");
        Product product = new Product(1, "4", 1, 1, "1",
                1, 1, 1);
        System.out.println(productRepository.getProductByName("4"));
*//*

    }
}*/
