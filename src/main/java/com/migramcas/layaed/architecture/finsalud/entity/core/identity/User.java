package com.migramcas.layaed.architecture.finsalud.entity.core.identity;

import com.migramcas.layaed.architecture.finsalud.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "users")
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    @EmbeddedId
    @Column(name = "user_id")
    private UserId id;

    @Column(name = "username")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "first_lastname")
    private String firstLastName;

    @Column(name = "second_lastname")
    private String secondLastName;

    protected User() {
    }
}
