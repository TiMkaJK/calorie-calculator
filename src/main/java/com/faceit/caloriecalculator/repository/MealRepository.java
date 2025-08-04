package com.faceit.caloriecalculator.repository;

import com.faceit.caloriecalculator.data.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
