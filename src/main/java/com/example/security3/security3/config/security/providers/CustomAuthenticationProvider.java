package com.example.security3.security3.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.security3.security3.config.security.authetication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${our.very.very.very.secrete.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication ca = (CustomAuthentication) authentication;
        String headerKey = ca.getKey();

        if (key.equals(headerKey)) {
            return new CustomAuthentication(true);
        }
        throw new BadCredentialsException("Oh No!");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return CustomAuthentication.class.equals(authentication);
    }

}
