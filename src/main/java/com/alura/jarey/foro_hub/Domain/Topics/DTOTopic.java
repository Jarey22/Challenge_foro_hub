package com.alura.jarey.foro_hub.Domain.Topics;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DTOTopic(
        @NotBlank
        @Size(min = 0, max = 100)
        String title,
        @NotBlank
        @Size(min = 0, max = 2000)
        String message,
        Tag tag,
        @NotNull
        Long user_id,
        @NotNull
        Long course_id
) {
}
