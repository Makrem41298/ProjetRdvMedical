package com.app.rdv.security.service;

import com.app.rdv.security.entity.AppUser;
import com.app.rdv.security.entity.Role;

public interface IServiceAuthentication {
    public   AppUser createAppUser(AppUser appUser);
    public  Role createRole(Role role);
    public  void addRoleToUser(String username, String role);
    public  AppUser LoadUserByUsername(String username);
}
