package by.onlineStore.mapper;

import by.onlineStore.bean.User;
import by.onlineStore.dto.CreateUserDto;
import by.onlineStore.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ProductMapper productMapper;

    public UserDto convertToUserDto(User user) {
        return Optional.of(user).map(localUser -> {
            UserDto userDto = new UserDto();
            userDto.setUserId(localUser.getId());
            userDto.setUserName(localUser.getName());
            userDto.setUserPassword(localUser.getPassword());
            userDto.setUserMail(localUser.getMail());
            userDto.setProducts(productMapper.convertToListProductDto(localUser.getProducts()));
            userDto.setComments(commentMapper.convertToListCommentDto(localUser.getComments()));
            return userDto;
        }).orElse(null);
    }

    public User convertToUser(UserDto userDto) {
        return Optional.of(userDto).map(localUserDto -> {
            User user = new User();
            user.setId(localUserDto.getUserId());
            user.setName(localUserDto.getUserName());
            user.setPassword(localUserDto.getUserPassword());
            user.setMail(localUserDto.getUserMail());
            return user;
        }).orElse(null);
    }

    public User convertToUser(CreateUserDto createUserDto) {
        return Optional.of(createUserDto).map(localCreateUserDto -> {
            User user = new User();
            user.setName(localCreateUserDto.getUserName());
            user.setPassword(localCreateUserDto.getUserPassword());
            user.setMail(localCreateUserDto.getUserMail());
            return user;
        }).orElse(null);
    }

    public List<UserDto> convertToListUserDto(List<User> userList) {
        return Optional.ofNullable(userList).map(localProductList ->
                localProductList.stream()
                        .map(this::convertToUserDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
