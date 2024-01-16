package com.khaoula.securityservice;

import com.khaoula.securityservice.entities.RoleEntity;
import com.khaoula.securityservice.entities.UserEntity;
import com.khaoula.securityservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new RoleEntity(null,"USER"));
            accountService.addNewRole(new RoleEntity(null,"ADMIN"));
            accountService.addNewRole(new RoleEntity(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new RoleEntity(null,"PRODUCT_MANAGER"));
            accountService.addNewRole(new RoleEntity(null,"BILLS_MANAGER"));

            accountService.addNewUser(new UserEntity(null,"user1","1234",new ArrayList<>()));
            accountService.addNewUser(new UserEntity(null,"admin","1234",new ArrayList<>()));
            accountService.addNewUser(new UserEntity(null,"user2","1234",new ArrayList<>()));
            accountService.addNewUser(new UserEntity(null,"user3","1234",new ArrayList<>()));
            accountService.addNewUser(new UserEntity(null,"user4","1234",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");
        };
    }
}
