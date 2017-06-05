package by.onlineStore.controller;

import by.onlineStore.Repository.ProductRepository;
import by.onlineStore.bean.Product;
import by.onlineStore.dto.ProductDto;
import by.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

/**
 * Created by Admin on 13.05.2017.
 */
@RestController
@RequestMapping(value = {"/product"}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
public class productController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public List<Product> getAllProduct() {
        ResponseEntity.status(HttpStatus.OK);
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) {
        ResponseEntity.status(HttpStatus.OK);
        return productService.getUserById(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody ProductDto productDto) {
        Product product=new Product(productDto);
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity(productService.getUserById(product.getIdProduct()), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto) {
        Product product=new Product(productDto);
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity(productService.getUserById(product.getIdProduct()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable("id") Long id) {
        ResponseEntity.status(HttpStatus.OK);
        productService.deleteProduct(id);
    }

}

