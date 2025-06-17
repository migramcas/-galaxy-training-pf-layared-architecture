package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.service.base.ProcessingService;
import com.migramcas.layaed.architecture.finsalud.service.command.GoalCommand;

@FunctionalInterface
public interface CreateGoalService extends ProcessingService<GoalCommand, Goal> {

}
