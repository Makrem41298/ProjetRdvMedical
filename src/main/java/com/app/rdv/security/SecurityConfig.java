package com.app.rdv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final HttpSecurity httpSecurity;

    public SecurityConfig(HttpSecurity httpSecurity) {
        this.httpSecurity = httpSecurity;
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder.encode("123456"))
                .authorities("USER")
                .build();

        UserDetails user2 = User.withUsername("admin")
                .password(passwordEncoder.encode("123456"))
                .authorities("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public SecurityFilterChain securityFilterChain(SecurityFilterChain securityFilterChain) throws Exception {
        return httpSecurity
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/api/rdv/create","/api/medecin/create","/api/patient/add").hasAnyAuthority("Admin")
                        .requestMatchers("/api/medecin/all").permitAll())
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
