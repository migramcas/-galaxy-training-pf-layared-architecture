package com.migramcas.layaed.architecture.finsalud.jobs;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserRepository;
import com.migramcas.layaed.architecture.finsalud.service.core.users.QueryExternalUsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JobUpdateUsers implements Job {

    QueryExternalUsersService queryExternalUsersService;
    UserRepository userRepository;

    @Autowired
    public JobUpdateUsers(QueryExternalUsersService queryExternalUsersService, UserRepository userRepository) {
        this.queryExternalUsersService = queryExternalUsersService;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Set<User> users = queryExternalUsersService.getAll();
        userRepository.deleteAllInBatch();
        userRepository.saveAllAndFlush(users);
    }

}
