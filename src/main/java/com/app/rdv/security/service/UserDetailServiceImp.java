package com.app.rdv.security.service;

import com.app.rdv.security.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
    private final IServiceAuthentication serviceAuthentication;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=serviceAuthentication.LoadUserByUsername(username);
        if (appUser==null) throw new UsernameNotFoundException("User with username " + username + " not found");
        String[] roles=appUser.getRoles().stream().map(role -> role.getRole()).toArray(String[]::new);
    return User
            .withUsername(appUser.getUsername())
            .password(appUser.getPassword())
            .roles(roles)
            .build();
    }
}
