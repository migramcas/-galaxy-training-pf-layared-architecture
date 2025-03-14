package com.migramcas.layaed.architecture.finsalud.entity.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Entity {

    protected boolean active;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

}
