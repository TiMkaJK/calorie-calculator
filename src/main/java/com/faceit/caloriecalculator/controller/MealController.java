package com.faceit.caloriecalculator.controller;

import com.faceit.caloriecalculator.data.entity.Meal;
import com.faceit.caloriecalculator.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService mealService;

    public ResponseEntity<Meal> saveMeal(@RequestParam("photo") MultipartFile photo) {

        return ResponseEntity.ok(new Meal());
    }
}

