package com.faceit.caloriecalculator.data.dto;

import com.faceit.caloriecalculator.data.entity.Item;
import com.faceit.caloriecalculator.data.entity.User;
import java.time.Instant;
import java.util.HashSet;
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
    private String screenshotLink;
    private User user;
    private Set<Item> items = new HashSet<>();
    private Instant createdAt;
    private Instant updatedAt;
}

