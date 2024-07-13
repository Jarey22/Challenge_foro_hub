package com.alura.jarey.foro_hub.Domain.User;

import jakarta.validation.constraints.NotNull;

public record DTOUserCourse(
        @NotNull
        Long user_id,
        @NotNull
        Long course_id
)  {
}
