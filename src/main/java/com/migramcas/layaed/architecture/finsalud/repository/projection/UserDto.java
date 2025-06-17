package com.migramcas.layaed.architecture.finsalud.repository.projection;

import java.time.LocalDateTime;

public record UserDto(
        int id,
        String email,
        String password,
        String name,
        String role,
        String avatar,
        LocalDateTime creationAt,
        LocalDateTime updatedAt
) {
}
