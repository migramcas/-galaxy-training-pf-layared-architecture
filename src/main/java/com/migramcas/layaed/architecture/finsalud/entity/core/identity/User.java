package com.migramcas.layaed.architecture.finsalud.entity.core.identity;

import com.migramcas.layaed.architecture.finsalud.entity.base.BaseEntity;
import com.migramcas.layaed.architecture.finsalud.repository.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@Table(name = "users")
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    @EmbeddedId
    @Column(name = "user_id")
    private UserId id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "first_lastname")
    private String firstLastName;

    @Column(name = "second_lastname")
    private String secondLastName;

    protected User() {
        super();
    }

    public static User of(UserDto dto) {
        return User.builder()
                .id(UserId.of(dto.id()))
                .email(dto.email())
                .name(dto.name())
                .firstLastName("")
                .secondLastName("")
                .active(true)
                .createdAt(dto.creationAt())
                .updatedAt(dto.updatedAt())
                .build();
    }
}
