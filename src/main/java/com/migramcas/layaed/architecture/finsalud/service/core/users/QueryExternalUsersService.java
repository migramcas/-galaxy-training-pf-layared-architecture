package com.migramcas.layaed.architecture.finsalud.service.core.users;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;

import java.util.Set;

@FunctionalInterface
public interface QueryExternalUsersService {

    Set<User> getAll();

}
