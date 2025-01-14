package com.QuickNotesAPI.QuickNotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
* Application security configuration, defining authorization rules,
* security filters, and authentication policies.
*/
@Configuration
public class SecurityConfig {
    /**
     * Configures security filters for the application, including authorizing
     * requests, disabling CSRF, creating stateless sessions,
     * and adding the JWT filter.
     *
     * @param http HTTP security configuration object provided by Spring Security.
     * @return SecurityFilterChain: The configured filter chain.
     * @throws Exception If an error occurs while configuring security.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/register",
                                "/api/auth/login")
                        .permitAll()
                        .requestMatchers("/api/user/list",
                                "/api/user/list/{lastNameInitial}",
                                "/api/user/{userId}",
                                "/api/user/disable/{userId}")
                        .hasRole("ADMIN")
                        .requestMatchers("/api/note/list/{userId}",
                                "/api/note/save/{userId}",
                                "/api/note/update",
                                "/api/note/delete/{noteId}")
                        .hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Add the JWT filter before the default Spring Security authentication filter
                .addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Defines the password encoder to be used in the application.
     * Uses the BCrypt algorithm to encode passwords.
     *
     * @return an instance of BCryptPasswordEncoder for password hashing.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Defines the JWT filter to be used to validate the token on each request.
     *
     * @return an instance of the JWT filter.
     */
    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter();
    }

}
