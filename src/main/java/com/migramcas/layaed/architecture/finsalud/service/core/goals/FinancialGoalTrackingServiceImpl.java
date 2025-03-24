package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CreateGoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.Goal;
import com.migramcas.layaed.architecture.finsalud.service.base.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class FinancialGoalTrackingServiceImpl implements FinancialGoalTrackingService {


    @Override
    public Goal execute(CreateGoalCommand createGoalCommand) throws ServiceException {
        return null;
    }


}
