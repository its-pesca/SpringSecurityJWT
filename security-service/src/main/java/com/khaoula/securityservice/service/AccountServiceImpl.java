package com.khaoula.securityservice.service;

import com.khaoula.securityservice.entities.RoleEntity;
import com.khaoula.securityservice.entities.UserEntity;
import com.khaoula.securityservice.repositories.RoleEntityRepository;
import com.khaoula.securityservice.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserEntity addNewUser(UserEntity userEntity) {
        String pw = userEntity.getPassword();
        userEntity.setPassword(passwordEncoder.encode(pw));
        return userEntityRepository.save(userEntity);
    }

    @Override
    public RoleEntity addNewRole(RoleEntity roleEntity) {
        return roleEntityRepository.save(roleEntity);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        RoleEntity roleEntity = roleEntityRepository.findByRoleName(roleName);
        userEntity.getRoleEntities().add(roleEntity);
    }

    @Override
    public UserEntity loadUserByUsername(String username) {
        return userEntityRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> listUsers() {
        return userEntityRepository.findAll();
    }
}
