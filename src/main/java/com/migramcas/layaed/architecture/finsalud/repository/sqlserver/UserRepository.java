package com.migramcas.layaed.architecture.finsalud.repository.sqlserver;


import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import com.migramcas.layaed.architecture.finsalud.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@Repository
@ApplicationScope
public interface UserRepository extends GenericRepository<User, UserId> {

    @Query("select u from User u where u.id = :id")
    Optional<User> getUserById(@Param("id") UserId id);

    @Query("select u from User u where u.userName = :username")
    Optional<User> getByUserName(@Param("username") String username);

}
