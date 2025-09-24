package com.faceit.caloriecalculator.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**", "/login", "/register", "/api/meals","/api/users/***", "/v3/api-docs/**", "/swagger-ui/**").permitAll() // Allow public access to these paths
                        .anyRequest().authenticated()) // All other requests require authentication
                .authenticationProvider(usernamePasswordAuthenticationProvider)
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo.oidcUserService(oauth2UserService())));

        return http.build();
    }

    @Bean
    public OidcUserService oauth2UserService() {
        return new Oauth2UserService();
    }

//    @Bean
//    public UserDetailsService userDet ailsService() {
//        return new UserDetailsServiceImpl(userRepository);
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//
//        return new ProviderManager(daoAuthenticationProvider);
//    }
}

