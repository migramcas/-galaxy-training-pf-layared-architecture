package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CreateGoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class FinancialGoalTrackingServiceImpl implements FinancialGoalTrackingService {


    @Override
    public Goal execute(CreateGoalCommand createGoalCommand) throws ServiceException {
        return Goal.builder().id(GoalId.of(1)).build();
    }


}
