package com.example.security3.security3.config.mananger;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.security3.security3.config.security.providers.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider provider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (provider.supports(authentication.getClass()))
            return provider.authenticate(authentication);
    }

}
