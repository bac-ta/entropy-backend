package com.entropy.backend.services;

import com.entropy.backend.models.rests.requests.users.UserOpenFireRegistrationRequest;

/**
 * Interface provide methods adapter to openfire API
 *
 * @author bac-ta
 * @see OpenfireService
 * @since 2021-05-31
 */
public interface OpenfireService {
    boolean createUser(UserOpenFireRegistrationRequest request);
}
