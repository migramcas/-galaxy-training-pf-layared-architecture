package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.GoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.service.base.ProcessingService;

@FunctionalInterface
public interface CreateGoalService extends ProcessingService<GoalCommand, Goal> {

}
