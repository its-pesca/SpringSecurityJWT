package com.khaoula.venteservice.JwtConfig;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    Algorithm algorithm = Algorithm.HMAC256(JwtUtil.SECRET);

    public String generateToken(String username, List<String> roles){
        String jwtAccessToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.EXPIRE_ACCESS_TOKEN))//5min avec step 14
                .withClaim("roles",roles)
                .sign(algorithm);

        return jwtAccessToken;
    }
}
