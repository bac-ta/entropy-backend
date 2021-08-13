package com.entropy.backend.services.impls;

import com.entropy.backend.models.rests.requests.users.UserOpenFireRegistrationRequest;
import com.entropy.backend.services.OpenfireService;
import org.springframework.stereotype.Service;

/**
 * This class implement {@link OpenfireService}
 *
 * @author bac-ta
 * @see OpenfireServiceImpl
 * @since 2021-05-31
 */
@Service
public class OpenfireServiceImpl implements OpenfireService {
    @Override
    public boolean createUser(UserOpenFireRegistrationRequest request) {

        return false;
    }
}
