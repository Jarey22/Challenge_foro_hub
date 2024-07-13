package com.alura.jarey.foro_hub.Domain.Answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOAnswer(
        @NotBlank
        String message,
        @NotNull
        Long topic_id,
        @NotNull
        Long user_id
) {
}
