package by.onlineStore.controller;


import by.onlineStore.dto.CreateProductDto;
import by.onlineStore.dto.ProductDto;
import by.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(value = {"/product"}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> getAllProduct() {

        return ResponseEntity.ok(productService.getAllProduct());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductDto> addProduct(@RequestBody CreateProductDto createProductDto) {

        return ResponseEntity.ok(productService.saveProduct(createProductDto));
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {

        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.ok().build();
    }

}

