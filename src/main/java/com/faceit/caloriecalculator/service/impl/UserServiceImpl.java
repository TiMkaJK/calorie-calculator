package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.constant.UserGender;
import com.faceit.caloriecalculator.data.constant.UserRole;
import com.faceit.caloriecalculator.data.constant.UserSubscription;
import com.faceit.caloriecalculator.data.dto.UserRequest;
import com.faceit.caloriecalculator.data.entity.Language;
import com.faceit.caloriecalculator.data.entity.Role;
import com.faceit.caloriecalculator.data.entity.Subscription;
import com.faceit.caloriecalculator.data.entity.User;
import com.faceit.caloriecalculator.repository.UserRepository;
import com.faceit.caloriecalculator.service.LanguageService;
import com.faceit.caloriecalculator.service.RoleService;
import com.faceit.caloriecalculator.service.SubscriptionService;
import com.faceit.caloriecalculator.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SubscriptionService subscriptionService;
    private final LanguageService languageService;
    private final RoleService roleService;

    @Override
    public User create(UserRequest userRequest) {

        Role role = roleService.findByName(UserRole.ROLE_USER.name());
        Subscription subscription = subscriptionService.findByName(UserSubscription.FREE.name());
        Language language = languageService.findByName(userRequest.getLanguage());

        User user = User.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .firstName("Tim")
                .lastName("Kumar")
                .subscription(subscription)
                .language(language)
                .roles(Set.of(role))
                .weight(167)
                .height(177)
                .gender(UserGender.MALE)
                .build();

        return userRepository.save(user);
    }
}

