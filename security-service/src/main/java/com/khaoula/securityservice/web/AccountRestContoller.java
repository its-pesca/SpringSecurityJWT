package com.khaoula.securityservice.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khaoula.securityservice.entities.RoleEntity;
import com.khaoula.securityservice.entities.UserEntity;
import com.khaoula.securityservice.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AccountRestContoller {

    @Autowired
    private AccountService accountService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return accountService.listUsers();
    }

    @PostMapping("/users")
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return accountService.addNewUser(userEntity);
    }

    @PostMapping("/roles")
    public RoleEntity saveRole(@RequestBody RoleEntity roleEntity){
        return accountService.addNewRole(roleEntity);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authToken = request.getHeader("Authorization");
        if (authToken!=null && authToken.startsWith("Bearer ")){
            try {
                String refreshToken = authToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("MySecret0#0");
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                UserEntity userEntity = accountService.loadUserByUsername(username);
                //s'il y a un changement de roles, il sera pris en consideration
                String jwtAccessToken = JWT.create()
                        .withSubject(username)
                        .withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",userEntity.getRoleEntities().stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                //generation d'un nouveau token

                Map<String,String> idToken = new HashMap<>();
                idToken.put("access-token",jwtAccessToken);
                idToken.put("refresh-token",refreshToken);
                response.setContentType("application/json");
                //envoyer le nouveau access token et l'ancient refresh token

                new ObjectMapper().writeValue(response.getOutputStream(),idToken);
            }catch (Exception e){
                throw e;
            }
        }
        else{
            throw new RuntimeException("Refresh Token Required!!!");
        }
    }

    @GetMapping("/profile")
    public UserEntity profile(Principal principal){
        return accountService.loadUserByUsername(principal.getName());
    }
}

@Data
class RoleUserForm{
    private String username;
    private String roleName;
}
