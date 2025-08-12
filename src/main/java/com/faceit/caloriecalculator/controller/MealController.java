package com.faceit.caloriecalculator.controller;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import com.faceit.caloriecalculator.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService mealService;

    @PostMapping
    public ResponseEntity<MealDTO> saveMeal(@RequestPart("photo") MultipartFile photo,
                                            Locale locale) throws IOException {
        mealService.save(photo, locale.getDisplayLanguage());

        return ResponseEntity.ok(new MealDTO());
    }
}

