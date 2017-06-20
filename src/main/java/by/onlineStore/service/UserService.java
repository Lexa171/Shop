package by.onlineStore.service;

import by.onlineStore.dto.CreateUserDto;
import by.onlineStore.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

    UserDto saveUser(CreateUserDto createUserDto);

    UserDto updateUser(UserDto userDto);
}
