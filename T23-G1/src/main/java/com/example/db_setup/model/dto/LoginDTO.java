package com.example.db_setup.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
