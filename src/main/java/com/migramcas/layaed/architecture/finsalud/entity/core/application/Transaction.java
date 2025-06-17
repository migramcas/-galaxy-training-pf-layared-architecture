package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import com.migramcas.layaed.architecture.finsalud.entity.base.BaseEntity;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
@SuperBuilder
@Table(name = "Transaction")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction extends BaseEntity {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TransactionId id;

    @Embedded
    private GoalId goalId;

    @Column(name = "user_id")
    private UserId userId;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private BigDecimal amount;

    protected Transaction() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

}
