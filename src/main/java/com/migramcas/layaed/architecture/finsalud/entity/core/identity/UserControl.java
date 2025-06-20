package com.migramcas.layaed.architecture.finsalud.entity.core.identity;

import com.migramcas.layaed.architecture.finsalud.entity.base.BaseEntity;
import com.migramcas.layaed.architecture.finsalud.repository.projection.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@Table(name = "usersControl")
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserControl extends BaseEntity {

    @EmbeddedId
    private UserControlId id;

    @Column(name = "user_id")
    private UserId userId;

    @Column(name = "password")
    private String password;

    @Column(name = "activation_account_date")
    protected LocalDateTime activationAccountDate;

    protected UserControl() {
        super();
    }


}
