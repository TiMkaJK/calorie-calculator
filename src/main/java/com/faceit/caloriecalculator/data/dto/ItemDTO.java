package com.faceit.caloriecalculator.data.dto;

import java.math.BigDecimal;
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
    private BigDecimal kilocalories;
    private BigDecimal proteins;
    private BigDecimal fats;
    private BigDecimal carbohydrates;
    private BigDecimal fiber;
    private Instant createdAt;
    private Instant updatedAt;
}

