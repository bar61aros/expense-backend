package com.barbaros.expense.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
