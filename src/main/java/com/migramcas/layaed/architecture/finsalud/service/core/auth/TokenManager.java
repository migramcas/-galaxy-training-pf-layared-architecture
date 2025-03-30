package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.entity.core.User;

public interface TokenManager {

    String createToken(User user);

    boolean validate(String token);

}
