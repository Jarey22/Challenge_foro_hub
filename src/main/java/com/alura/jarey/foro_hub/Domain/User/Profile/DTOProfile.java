package com.alura.jarey.foro_hub.Domain.User.Profile;

import jakarta.validation.constraints.NotNull;

public record DTOProfile(
        @NotNull
        Long user_id,
        @NotNull
        Long profile_id
) {
}
