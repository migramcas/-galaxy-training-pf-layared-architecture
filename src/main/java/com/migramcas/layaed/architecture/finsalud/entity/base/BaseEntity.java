package com.migramcas.layaed.architecture.finsalud.entity.base;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {

    @Column(name = "active")
    protected boolean active;

    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

}
