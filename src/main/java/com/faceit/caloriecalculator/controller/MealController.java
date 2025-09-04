package com.faceit.caloriecalculator.controller;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import com.faceit.caloriecalculator.service.MealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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
@Tag(name = "Meals", description = "Endpoints for managing meals")
public class MealController {

    private final MealService mealService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Create and analyze a meal from a photo",
            description = "Uploads a meal photo, analyzes its nutritional information, and returns the detected items and total nutrients.")
    @RequestBody(
            required = true,
            content = @Content(
                    mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                    schema = @Schema(type = "object", requiredProperties = {"photo"}),
                    encoding = {
                            @Encoding(name = "photo", contentType = "image/*")
                    }
            )
    )
    @ApiResponse(responseCode = "200", description = "Meal saved successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MealDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    @ApiResponse(responseCode = "500", description = "Server error", content = @Content)
    public ResponseEntity<MealDTO> saveMeal(@RequestPart("photo") MultipartFile photo,
                                            Locale locale) throws IOException {
        return ResponseEntity.ok(mealService.save(photo, locale.getDisplayLanguage()));
    }
}

