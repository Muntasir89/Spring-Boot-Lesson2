package com.practice.firstproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please Add Department Name")
//    @Leng th(max=5, min = 1)
//    @Size(max=10, min = 0)
//    @Email
//    @Positive
//    @Negative
//    @NegativeOrZero
//    @PositiveOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
