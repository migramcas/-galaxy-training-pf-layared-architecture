package com.migramcas.layaed.architecture.finsalud.repository.mysql;


import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends GenericRepository<Goal, GoalId> {

    @Query("SELECT MAX(g.id.value) + 1 FROM Goal g")
    Integer getNextId();

}
