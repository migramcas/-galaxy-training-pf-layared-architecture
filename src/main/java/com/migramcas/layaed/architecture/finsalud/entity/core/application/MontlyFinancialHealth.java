package com.migramcas.layaed.architecture.finsalud.entity.core.application;


import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.Month;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Table(name = "MontlyFinancialHealth")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class MontlyFinancialHealth {

    @EmbeddedId
    UserId userId;

    @Enumerated
    @Column(name = "month_id")
    Month month;

    @Column(name = "year")
    Integer year;

    @Enumerated
    @Column(name = "health_id")
    FinancialHealth health;

    protected MontlyFinancialHealth() {
    }

}
