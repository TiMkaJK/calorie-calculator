package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import com.faceit.caloriecalculator.data.entity.Item;
import com.faceit.caloriecalculator.data.entity.Meal;
import com.faceit.caloriecalculator.repository.MealRepository;
import com.faceit.caloriecalculator.service.ChatGPTService;
import com.faceit.caloriecalculator.service.FileStorageService;
import com.faceit.caloriecalculator.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final ChatGPTService chatGPTService;
    private final FileStorageService fileStorageService;

    @Override
    public MealDTO save(MultipartFile photo, String locale) throws IOException {
        Meal meal = new Meal();
        Set<Item> items = chatGPTService.getMealItems(photo.getContentType(), photo.getInputStream(), locale).stream()
//                .map()
                .collect(Collectors.toSet());
        meal.setItems(items);

        fileStorageService.storeFile(photo);
        return null;
    }

    private Float calculateSummary(Float item, Integer weight) {
        return BigDecimal.valueOf(weight).multiply(BigDecimal.valueOf(item)).floatValue();
    }
}

