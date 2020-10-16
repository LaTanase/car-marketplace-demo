package com.laurentiutanase.carmarketplacedemo.repository;

import com.laurentiutanase.carmarketplacedemo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>,
        JpaSpecificationExecutor<UserEntity> {
}
