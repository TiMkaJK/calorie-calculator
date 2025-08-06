package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.entity.Meal;
import java.io.InputStream;

public interface MealService {

    Meal save(String contentType, InputStream imageInputStream);
}
