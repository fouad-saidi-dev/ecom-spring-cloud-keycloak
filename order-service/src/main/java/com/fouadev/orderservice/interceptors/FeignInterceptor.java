package com.fouadev.orderservice.interceptors;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication == null || !(authentication instanceof JwtAuthenticationToken)) {
            // Handle the unauthenticated case or log a warning
            System.out.println("No JWT Authentication token found");
            return;
        }
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String accessToken = jwtAuthenticationToken.getToken().getTokenValue();
        System.out.println("access token ===> ");
        System.out.println(accessToken);
        //        OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) authentication.getCredentials();
//        DefaultOidcUser oidcUser = (DefaultOidcUser) oAuth2AccessToken.;
//        String accessToken = oidcUser.getIdToken().getTokenValue();
    }
}