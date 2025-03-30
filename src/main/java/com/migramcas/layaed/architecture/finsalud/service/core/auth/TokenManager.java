package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;

import java.util.Map;

public interface TokenManager {

    String createToken(User user);

    boolean validate(String token);

    Map<String, String> getPayload(String token);

}
