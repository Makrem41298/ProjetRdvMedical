package com.app.rdv.security.controlller;

import com.app.rdv.security.entity.AppUser;
import com.app.rdv.security.entity.Role;
import com.app.rdv.security.service.IServiceAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
class AuthenticationController {
    IServiceAuthentication serviceAuthentication;
    @PostMapping("/add_user")
    public ResponseEntity<?> createAppUser(@RequestBody AppUser appUser){
        AppUser user=serviceAuthentication.createAppUser(appUser);
        if(user != null)
            return  new ResponseEntity<>(user, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("user don't add",HttpStatus.NOT_ACCEPTABLE);
    }
    @PostMapping("/add_role")
    public ResponseEntity<?> createRole(@RequestBody Role role){
         Role roleUser=serviceAuthentication.createRole(role);
        if(roleUser != null)
            return  new ResponseEntity<>(roleUser, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("role don't add",HttpStatus.CREATED);

    }

    @PostMapping("/add_user_role")
    public ResponseEntity<?> addRoleToUser(
            @RequestParam String username,
            @RequestParam String role) {
        try {
            serviceAuthentication.addRoleToUser(username, role);
            return ResponseEntity.ok("Role added successfully to user: " + username);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error: " + e.getMessage());
        }
    }



}
