package com.app.rdv.security.service;

import com.app.rdv.security.entity.AppUser;
import com.app.rdv.security.entity.Role;
import com.app.rdv.security.repository.AppRoleRepository;
import com.app.rdv.security.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
class AuthenticationService  implements IServiceAuthentication{
    private final  AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Override
    public AppUser createAppUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return  appUserRepository.save(appUser);
    }

    @Override
    public Role createRole(Role role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        Role role = appRoleRepository.findByRole(roleName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        if (role == null) {
            throw new IllegalArgumentException("Role not found: " + roleName);
        }
        if (user.getRoles().contains(role)) {
            throw new IllegalStateException("User already has role: " + roleName);
        }

        user.getRoles().add(role);
        appUserRepository.save(user);
    }


    @Override
    public AppUser LoadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
