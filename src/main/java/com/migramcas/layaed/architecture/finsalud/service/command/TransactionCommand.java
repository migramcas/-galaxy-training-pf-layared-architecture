package com.migramcas.layaed.architecture.finsalud.service.command;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.TransactionType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionCommand {

    private GoalId goalId;
    private TransactionType type;
    private String name;
    private BigDecimal amount;
    private User user;

}
