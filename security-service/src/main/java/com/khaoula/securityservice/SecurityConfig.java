package com.khaoula.securityservice;

import com.khaoula.securityservice.entities.UserEntity;
import com.khaoula.securityservice.filters.JwtAuthenticationFilter;
import com.khaoula.securityservice.filters.JwtAuthorizationFilter;
import com.khaoula.securityservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@Service
public class SecurityConfig {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private AccountService accountService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager = new InMemoryUserDetailsManager() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserEntity userEntity = accountService.loadUserByUsername(username);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                userEntity.getRoleEntities().forEach(r -> {
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                });
                return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);

            }
        };
        return inMemoryUserDetailsManager;
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests((auth) ->
                auth.requestMatchers("/h2-console/**","/refreshToken/**","/login/**").permitAll());
        http.authorizeHttpRequests((auth) -> auth.requestMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN"));
        http.authorizeHttpRequests((auth) -> auth.requestMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER"));
        http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated());
        http.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBuilder.getOrBuild()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
