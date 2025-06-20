package com.migramcas.layaed.architecture.finsalud.repository.sqlserver;


import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserControl;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserControlId;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import com.migramcas.layaed.architecture.finsalud.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@Repository
@ApplicationScope
public interface UserControlRepository extends GenericRepository<UserControl, UserControlId> {

    @Query("SELECT COALESCE(MAX(uc.id.value), 0) + 1 FROM UserControl uc")
    Integer getNextId();

    @Query("select u from UserControl u where u.userId = :userId")
    Optional<UserControl> getUserById(@Param("userId") UserId userId);

}
