package com.faceit.caloriecalculator.data.dto;

import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MealDTO {

    private Long id;
    private String screenshot;
    private Set<ItemDTO> items;
    private Instant createdAt;
    private Instant updatedAt;
}

