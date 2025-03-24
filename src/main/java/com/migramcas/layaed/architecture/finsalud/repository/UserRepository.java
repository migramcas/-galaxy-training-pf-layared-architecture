package com.migramcas.layaed.architecture.finsalud.repository;

import com.migramcas.layaed.architecture.finsalud.entity.core.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.UserId;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepository {

    Optional<User> getById(UserId id) throws SQLException;

}
