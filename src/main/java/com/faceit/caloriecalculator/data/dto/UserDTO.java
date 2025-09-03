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
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String picture;
    private Instant birthDate;
    private Set<MealDTO> meals;
    private Instant createdAt;
    private Instant updatedAt;
}

