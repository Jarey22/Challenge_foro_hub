package com.alura.jarey.foro_hub.Domain.Topics;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DTOUpdate(
        @NotNull
        Long id,
        @Size(min = 0, max = 100)
        String title,
        @Size(min = 0, max = 2000)
        String message,
        Status status,
        Tag tag
) {
}
