package com.fouadev.inventoryservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/*
 Created by : Fouad SAIDI on 16/12/2024
 @author : Fouad SAIDI
 @date : 16/12/2024
 @project : ecom-spring-cloud-security
*/
@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(r->r.requestMatchers("/api/**","/h2-console/**").permitAll())
                .authorizeHttpRequests(r->r.anyRequest().authenticated())
                .build();
    }
}