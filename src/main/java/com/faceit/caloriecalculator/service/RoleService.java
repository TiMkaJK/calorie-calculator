package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.entity.Role;

public interface RoleService {

    Role findByName(String name);
}
