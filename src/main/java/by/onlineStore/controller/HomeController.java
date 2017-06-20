package by.onlineStore.controller;


import by.onlineStore.bean.Product;
import by.onlineStore.repository.ProductRepository;
import by.onlineStore.repository.UserRepository;
import by.onlineStore.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping(value = {"/", ""}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public void viewHome() {
        ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) {
        ResponseEntity.status(HttpStatus.OK);
        Product product = productRepository.getOne(id);
        return product;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserAll() {
        ResponseEntity.status(HttpStatus.OK);
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @RequestMapping(value = {"/reg"}, method = RequestMethod.GET)
    @ResponseBody
    public void addUser(Model model) {
        ResponseEntity.status(HttpStatus.OK);
        model.addAttribute("user", userRepository);
    }
}


