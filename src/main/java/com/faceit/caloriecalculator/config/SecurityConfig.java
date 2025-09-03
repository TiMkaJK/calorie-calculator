package com.faceit.caloriecalculator.config;

import com.faceit.caloriecalculator.data.entity.User;
import com.faceit.caloriecalculator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**", "/login", "/register", "/api/meals", "/v3/api-docs", "/swagger-ui/***").permitAll() // Allow public access to these paths
                        .anyRequest().authenticated()) // All other requests require authentication
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo.oidcUserService(this.oidcUserService())));

        return http.build();
    }

    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        final OidcUserService delegate = new OidcUserService();

        return (userRequest) -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);

            String email = oidcUser.getEmail();
            String firstName = oidcUser.getGivenName();
            String lastName = oidcUser.getFamilyName();
            String picture = oidcUser.getPicture();

            User user = userRepository.findByEmail(email)
                    .orElseGet(() -> User.builder()
                            .email(email)
                            .firstName(firstName)
                            .lastName(lastName)
                            .picture(picture)
                            .build());

            userRepository.save(user);

            return oidcUser;
        };
    }
}

