package com.fouadev.inventoryservice.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 Created by : Fouad SAIDI on 26/12/2024
 @author : Fouad SAIDI
 @date : 26/12/2024
 @project : ecom-spring-cloud-security
*/
@RestController
@RequestMapping("/api/auth")
public class SecurityRestController {

    @GetMapping
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}