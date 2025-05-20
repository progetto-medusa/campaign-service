package com.progettomedusa.campaign_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    
//    @Bean
//    public SecurityFilterChain securityFIlterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorizeRequests ->
//            authorizeRequests
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/gm/**").hasRole("GAME_MASTER")
//                .requestMatchers("/user/**").hasAnyRole("ADMIN", "GAME_MASTER", "PLAYER")
//                .requestMatchers("/public/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(formLogin ->
//                formLogin
//                    .loginPage("/login")
//                    .permitAll()
//            )
//            .logout(logout ->
//                logout
//                    .permitAll()
//            );
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("admin")
//            .roles("ADMIN")
//            .build();
//
//        UserDetails gameMaster = User.withDefaultPasswordEncoder()
//            .username("gm")
//            .password("gm")
//            .roles("GAME_MASTER")
//            .build();
//
//        UserDetails player = User.withDefaultPasswordEncoder()
//            .username("player")
//            .password("player")
//            .roles("PLAYER")
//            .build();
//
//            return new InMemoryUserDetailsManager(admin, gameMaster, player);
//    }
}