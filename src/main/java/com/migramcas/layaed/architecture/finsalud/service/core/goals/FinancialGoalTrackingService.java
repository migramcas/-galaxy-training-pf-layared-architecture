package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CreateGoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.Goal;
import com.migramcas.layaed.architecture.finsalud.service.base.ProcessingService;

@FunctionalInterface
public interface FinancialGoalTrackingService extends ProcessingService<CreateGoalCommand, Goal> {

}
