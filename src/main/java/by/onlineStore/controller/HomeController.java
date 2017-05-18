package by.onlineStore.controller;


import by.onlineStore.bean.Product;
import by.onlineStore.jdbcTemplate.ProductRepository;
import by.onlineStore.jdbcTemplate.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping(value = {"/",""})
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
        public void viewHome(){
        ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable("id") Integer id){
        ResponseEntity.status(HttpStatus.OK);
        Product product = productRepository.findById(id);

        return product;

    }
    @RequestMapping(value = { "/reg" },produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public void addUser(Model model) {
        ResponseEntity.status(HttpStatus.OK);
        model.addAttribute("user", userRepository);
    }
    }


