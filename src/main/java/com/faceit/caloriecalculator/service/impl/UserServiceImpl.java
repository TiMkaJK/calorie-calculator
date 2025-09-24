package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.constant.UserGender;
import com.faceit.caloriecalculator.data.constant.UserLanguage;
import com.faceit.caloriecalculator.data.constant.UserSubscription;
import com.faceit.caloriecalculator.data.dto.UserRequest;
import com.faceit.caloriecalculator.data.entity.Language;
import com.faceit.caloriecalculator.data.entity.Subscription;
import com.faceit.caloriecalculator.data.entity.User;
import com.faceit.caloriecalculator.repository.UserRepository;
import com.faceit.caloriecalculator.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(UserRequest userRequest) {

        User user = User.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .firstName("Tim")
                .lastName("Kumar")
                .subscription(Subscription.builder().name(UserSubscription.FREE.name()).build())
                .language(Language.builder().name(UserLanguage.ENGLISH.name()).code("EN").build())
                .weight(167)
                .height(177)
                .gender(UserGender.MALE)
                .build();

        return userRepository.save(user);
    }
}

