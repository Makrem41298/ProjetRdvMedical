package com.app.rdv.security.repository;

import com.app.rdv.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<Role, Integer> {


    public Role findByRole(String role);
}
