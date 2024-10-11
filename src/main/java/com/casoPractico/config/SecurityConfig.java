package com.casoPractico.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.security.user.name}")
    private String username = "admin";

    @Value("${spring.security.user.password}")
    private String password = "vadminpass";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated()  // Requiere autenticación para todas las solicitudes
                )
                .httpBasic(withDefaults())  // Habilita la autenticación básica
                .csrf(csrf -> csrf.disable());  // Desactiva CSRF para APIs REST

        return http.build();
    }

}
