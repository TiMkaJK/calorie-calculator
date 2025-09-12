package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.dto.UserRequest;
import com.faceit.caloriecalculator.data.entity.User;

public interface UserService {

    User create(UserRequest userRequest);
}
