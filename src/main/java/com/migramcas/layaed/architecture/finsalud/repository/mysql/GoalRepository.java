package com.migramcas.layaed.architecture.finsalud.repository.mysql;


import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository {

    @Query("select r from Goal g where g.id = :id")
    Goal getById(GoalId id);

}
