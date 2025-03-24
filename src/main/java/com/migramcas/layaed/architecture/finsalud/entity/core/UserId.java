package com.migramcas.layaed.architecture.finsalud.entity.core;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserId {

    Integer value;

    public static UserId of (Integer value) {
        return new UserId(value);
    }
}
