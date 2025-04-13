package com.migramcas.layaed.architecture.finsalud.repository.mysql;


import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import com.migramcas.layaed.architecture.finsalud.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends GenericRepository<Goal, GoalId> {

    @Query("SELECT MAX(g.id.value) + 1 FROM Goal g")
    Integer getNextId();

    @Query("SELECT g FROM Goal g WHERE g.userId = :userId")
    List<Goal> getAllByUserId(UserId userId);

}
