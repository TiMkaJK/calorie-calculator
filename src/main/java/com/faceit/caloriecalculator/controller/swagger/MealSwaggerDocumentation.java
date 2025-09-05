package com.faceit.caloriecalculator.controller.swagger;

import com.faceit.caloriecalculator.data.dto.MealDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Locale;

@Tag(name = "Meals", description = "Endpoints for managing meals")
public interface MealSwaggerDocumentation {

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
    ResponseEntity<MealDTO> saveMeal(MultipartFile photo, Locale locale) throws IOException;
}

