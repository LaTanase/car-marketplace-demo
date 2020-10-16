package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.User;

import java.util.List;

/**
 * User Data Access Object
 *
 * Translates between Open Api User and Persistence User
 */
public interface UserEntityDao {
    /**
     * Transformers
     */
    UserEntity toEntity(User user);

    User fromEntity(UserEntity userEntity);

    List<User> fromEntityList(List<UserEntity> userEntities);

    /**
     * CRUD
     */
    UserEntity get(String id);

    List<UserEntity> getAll();

    void save(UserEntity userEntity);
}
