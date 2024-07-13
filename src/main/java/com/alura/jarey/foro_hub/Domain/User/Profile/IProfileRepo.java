package com.alura.jarey.foro_hub.Domain.User.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileRepo extends JpaRepository<UProfile, Long> {
}
