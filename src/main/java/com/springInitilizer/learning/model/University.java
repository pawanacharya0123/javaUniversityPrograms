package com.springInitilizer.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Mandatory! Uni Entity")
    @NotBlank @NotNull
    private String name;
    @NotNull(message = "Address is Mandatory!")
    private String address;
    @NotNull(message = "Country is Mandatory!")
    private String country;
    private String state;
    private String  schoolType;
    @NotNull(message = "Founded Date is Mandatory!")
    private String founded;
    private String  instituteType;
    private String applicationFee;
    private String  averageGraduteProgram;
    private String averageUndergraduteProgram;
    private String costOfLiving;
    private String tuition;
    private String about;
    private String features;
    private String location;
}
