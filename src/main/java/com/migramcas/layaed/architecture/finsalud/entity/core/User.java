package com.migramcas.layaed.architecture.finsalud.entity.core;

import com.migramcas.layaed.architecture.finsalud.entity.base.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User extends Entity {

    private UserId id;

    private String name;

    private String firstLastName;

    private String secondLastName;

}
