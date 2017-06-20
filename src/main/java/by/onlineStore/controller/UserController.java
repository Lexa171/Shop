package by.onlineStore.controller;

import by.onlineStore.dto.CreateUserDto;
import by.onlineStore.dto.UserDto;
import by.onlineStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUser() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> addUser(@RequestBody CreateUserDto createUserDto) {

        return ResponseEntity.ok(userService.saveUser(createUserDto));
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok().build();
    }
}
