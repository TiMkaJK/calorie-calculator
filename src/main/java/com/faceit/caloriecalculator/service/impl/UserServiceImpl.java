package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.constant.Gender;
import com.faceit.caloriecalculator.data.constant.Language;
import com.faceit.caloriecalculator.data.constant.Subscription;
import com.faceit.caloriecalculator.data.dto.UserRequest;
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
                .subscription(Subscription.FREE)
                .language(Language.ENGLISH)
                .weight(167)
                .height(177)
                .gender(Gender.MALE)
                .build();

        return userRepository.save(user);
    }
}

