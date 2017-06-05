package by.onlineStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
@SpringBootApplication
public class Application /*extends SpringBootServletInitializer */{

    public static void main(String[] args)throws Exception {
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
