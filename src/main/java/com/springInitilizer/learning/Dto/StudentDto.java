package com.springInitilizer.learning.Dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotNull(message = "Uni DTO; Name not found!")
    private String name;
    private String address;
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
