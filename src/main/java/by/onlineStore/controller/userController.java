package by.onlineStore.controller;

import by.onlineStore.Repository.UserRepository;
import by.onlineStore.bean.User;
import by.onlineStore.dto.UserDto;
import by.onlineStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 13.05.2017.
 */
@RestController
@RequestMapping(value = "/users")
public class userController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public List<User> getAllProduct() {
        ResponseEntity.status(HttpStatus.OK);
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getProduct(@PathVariable("id") Long id) {
        ResponseEntity.status(HttpStatus.OK);
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody UserDto userDto) {
        User user=new User(userDto);
        return new ResponseEntity(userService.getUserById(user.getIdUser()), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
        User user=new User(userDto);
        userService.saveOrUpdateUser(user);
        return new ResponseEntity( userService.getUserById(user.getIdUser()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable("id") Long id) {
        ResponseEntity.status(HttpStatus.OK);
        userService.deleteUser(id);
    }
}
