package com.khaoula.securityservice.service;

import com.khaoula.securityservice.entities.RoleEntity;
import com.khaoula.securityservice.entities.UserEntity;

import java.util.List;

public interface AccountService {

    UserEntity addNewUser(UserEntity userEntity);
    RoleEntity addNewRole(RoleEntity roleEntity);
    void addRoleToUser(String username, String roleName);

    UserEntity loadUserByUsername(String username);

    List<UserEntity> listUsers();

}
