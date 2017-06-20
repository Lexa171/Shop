package by.onlineStore.service.impl;

import by.onlineStore.repository.UserRepository;
import by.onlineStore.dto.CreateUserDto;
import by.onlineStore.dto.UserDto;
import by.onlineStore.exception.NotFoundException;
import by.onlineStore.mapper.UserMapper;
import by.onlineStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto getUserById(Long userId) {
        return userMapper.convertToUserDto(userRepository.findOneById(userId)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.convertToListUserDto(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public UserDto saveUser(CreateUserDto createUserDto) {
        return userMapper.convertToUserDto(userRepository.saveAndFlush(
                userMapper.convertToUser(createUserDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userMapper.convertToUserDto(userRepository.saveAndFlush(
                userMapper.convertToUser(userDto)));
    }


}
