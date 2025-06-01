package com.example.db_setup.model.dto;

import com.example.db_setup.model.Studies;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationDTO {
    @NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "[a-zA-Z]([a-zA-Z']*[a-zA-Z])?([-\\s][a-zA-Z]([a-zA-Z']*[a-zA-Z])?)*"
    )
    private String name;
    @NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "[a-zA-Z]([a-zA-Z']*[a-zA-Z])?([-\\s][a-zA-Z]([a-zA-Z']*[a-zA-Z])?)*"
    )
    private String surname;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 8, max = 16) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,16}$")
    private String password;
    @NotBlank
    private Studies studies;
}
