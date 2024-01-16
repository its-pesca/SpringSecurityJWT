package com.khaoula.securityservice.repositories;

import com.khaoula.securityservice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);
}
