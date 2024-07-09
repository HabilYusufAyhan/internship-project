package com.internship.pokemon.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class PokemonSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw,active from trainers where user_id=?"
        );
        userDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from trainers where user_id=?"
        );
        System.out.println(userDetailsManager);
        return userDetailsManager;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/trainers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/trainers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/trainers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/trainers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/trainers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/pokemons").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/pokemons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/pokemons").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/pokemons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/pokemons/**").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
