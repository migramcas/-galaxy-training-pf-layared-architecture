package com.migramcas.layaed.architecture.finsalud.entity.core;

import lombok.NonNull;
import lombok.Value;

@Value
public class GoalId {

    @NonNull
    Integer value;


    public static GoalId of(Integer id){
        return new GoalId(id);
    }

}
