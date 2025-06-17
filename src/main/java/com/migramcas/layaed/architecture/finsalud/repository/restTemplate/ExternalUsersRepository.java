package com.migramcas.layaed.architecture.finsalud.repository.restTemplate;

import com.migramcas.layaed.architecture.finsalud.repository.projection.UserDto;

@FunctionalInterface
public interface ExternalUsersRepository {

    UserDto[] getAllUsers();

}
