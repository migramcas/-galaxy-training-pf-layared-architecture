package com.migramcas.layaed.architecture.finsalud.entity.core;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Plan {

    Goal goal;

    List<Transaction> transactions;

}
