package com.faceit.caloriecalculator.data.mapper;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import com.faceit.caloriecalculator.data.entity.Meal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealMapper extends EntityMapper<MealDTO, Meal> {

}
