package com.app.rdv.security.repository;

import com.app.rdv.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<com.app.rdv.security.entity.AppUser, Integer> {


    public AppUser findByUsername(String username);

    List<AppUser> username(String username);
}
