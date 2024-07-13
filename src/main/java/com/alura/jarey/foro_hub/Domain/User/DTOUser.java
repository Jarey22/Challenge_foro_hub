package com.alura.jarey.foro_hub.Domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DTOUser(
        @NotBlank
        String first_name,
        @NotBlank
        String last_name,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
)  {
}
