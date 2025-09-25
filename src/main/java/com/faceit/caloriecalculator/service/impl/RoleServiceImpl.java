package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.entity.Role;
import com.faceit.caloriecalculator.repository.RoleRepository;
import com.faceit.caloriecalculator.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Role with name " + name + " not found"));
    }
}

