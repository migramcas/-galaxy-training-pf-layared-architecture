package com.migramcas.layaed.architecture.finsalud.entity.core;

import com.migramcas.layaed.architecture.finsalud.entity.base.Entity;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Transaction extends Entity {

    private TransactionId id;

    private UserId userId;

    private TransactionType type;

    private String name;

    private BigDecimal amount;

}
