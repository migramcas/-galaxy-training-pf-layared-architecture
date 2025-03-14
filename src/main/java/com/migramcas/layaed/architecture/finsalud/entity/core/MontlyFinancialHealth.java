package com.migramcas.layaed.architecture.finsalud.entity.core;


import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.Month;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MontlyFinancialHealth {

    UserId userId;

    Month month;

    Integer year;

    FinancialHealth health;

}
