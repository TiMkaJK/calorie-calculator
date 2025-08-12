package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MealService {

    MealDTO save(MultipartFile file, String locale) throws IOException;
}
