package com.learn.project.Bootcamp.Project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
    
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Override
    public boolean login(String userName, String password) {
        System.out.println(userName);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        System.out.println(userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result=token.isAuthenticated();

        if(result){
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        return result;
    }
}
