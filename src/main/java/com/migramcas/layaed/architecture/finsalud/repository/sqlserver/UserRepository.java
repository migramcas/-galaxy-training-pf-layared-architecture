package com.migramcas.layaed.architecture.finsalud.repository.sqlserver;

import com.migramcas.layaed.architecture.finsalud.entity.core.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getById(String id);

    Optional<User> getByUserName(String username);

}
