package com.faceit.caloriecalculator.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.Instant;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight",  nullable = false)
    private Integer weight;

    @Column(name = "kilocalories", nullable = false)
    private Float kilocalories;

    @Column(name = "proteins",  nullable = false)
    private Float proteins;

    @Column(name = "fats",  nullable = false)
    private Float fats;

    @Column(name = "carbohydrates",  nullable = false)
    private Float carbohydrates;

    @Column(name = "fiber",   nullable = false)
    private Float fiber;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;
}

