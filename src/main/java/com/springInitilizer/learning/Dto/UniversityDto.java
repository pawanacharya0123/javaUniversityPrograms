package com.springInitilizer.learning.Dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UniversityDto {
    @NotBlank(message = "Uni Name is required! DTO!")
    private String name;
    @Email(message = "must be an EMail Address")
    @NotEmpty(message = "address is not empty")
    @NotBlank @NotNull
    private String address;
    @NotNull
    private String country;
    @NotNull
    private String state;
    @NotNull
    private String  schoolType;
    @NotNull
    private String founded;
    @NotNull
    private String  instituteType;
    @NotNull
    private String applicationFee;
    @NotNull
    private String  averageGraduteProgram;
    @NotNull
    private String averageUndergraduteProgram;
    @NotNull
    private String costOfLiving;
    @NotNull
    private String tuition;
    @NotEmpty
    private String about;
    @NotBlank
    private String features;
    @NotEmpty
    private String location;
}

