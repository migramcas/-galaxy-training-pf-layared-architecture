package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.GoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class GoalServiceImpl implements GoalService<Goal, GoalCommand, GoalId> {


    @Override
    public List<Goal> getAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Goal> getById(GoalId goalId) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public GoalCommand add(Goal goal) throws ServiceException {
        return null;
    }

    @Override
    public GoalCommand update(Goal goal) throws ServiceException {
        return null;
    }

    @Override
    public void delete(Goal goal) throws ServiceException {

    }
}
