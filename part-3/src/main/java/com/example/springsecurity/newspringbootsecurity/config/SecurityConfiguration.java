package com.example.springsecurity.newspringbootsecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(csrf -> csrf.disable());
            http.authorizeHttpRequests(rQ -> {
                rQ.requestMatchers("/api/**", "/signup/", "/signin/").permitAll();
                rQ.requestMatchers("/api/search/", "/api/profile/", "/signout/").authenticated();
            });
            http.sessionManagement(sessionAuthenticationStrategy ->
                    sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            http.authenticationProvider(authenticationProvider);
            http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }

}
