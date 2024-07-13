package com.alura.jarey.foro_hub.Domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepo extends JpaRepository<User, Long>{
        UserDetails findByUsername(String username);
    }
