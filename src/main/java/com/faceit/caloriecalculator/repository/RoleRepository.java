package com.faceit.caloriecalculator.repository;

import com.faceit.caloriecalculator.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
