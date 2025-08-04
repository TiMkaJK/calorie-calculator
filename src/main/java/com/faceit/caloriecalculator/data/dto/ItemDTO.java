package com.faceit.caloriecalculator.data.dto;

import com.faceit.caloriecalculator.data.entity.Meal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private Long id;
    private String name;
    private Integer weight;
    private Integer proteins;
    private Integer fats;
    private Integer carbohydrates;
    private Integer fiber;
    private Instant createdAt;
    private Instant updatedAt;
    private Meal meal;
}

