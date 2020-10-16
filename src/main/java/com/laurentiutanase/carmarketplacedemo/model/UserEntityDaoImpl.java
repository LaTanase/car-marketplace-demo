package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.User;
import com.laurentiutanase.carmarketplacedemo.repository.UserRepository;
import com.laurentiutanase.carmarketplacedemo.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityDaoImpl implements UserEntityDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity toEntity(User user) {
        return new UserEntity.UserEntityBuilder()
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User fromEntity(UserEntity userEntity) {
        return null;
    }

    @Override
    public List<User> fromEntityList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity get(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "Failed to find user by id" + id + ". The searched resource does not exist!"
        ));
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
