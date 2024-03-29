package com.web.onlineshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityOnlineShop {

    private static final String CLIENT_ROLE = "CLIENT";
    private static final String ADMIN_ROLE = "ADMIN";
    @Bean
    public InMemoryUserDetailsManager users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails client = users
                .username("client")
                .password("password")
                .roles(CLIENT_ROLE)
                .build();
        UserDetails admin = users
                .username("admin")
                .password("security")
                .roles(ADMIN_ROLE, CLIENT_ROLE)
                .authorities(ADMIN_ROLE)
                .build();
        return new InMemoryUserDetailsManager(client, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/clients/").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.POST, "/clients/").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/clients/").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.GET, "/clients/", "/products/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/clients/", "/products/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/clients/", "/products/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/clients/", "/products").hasRole("ADMIN")
                        .requestMatchers("/price").permitAll()
                        .requestMatchers("/hryvnia").permitAll()
                        .anyRequest().authenticated())
                .build();
    }
}
