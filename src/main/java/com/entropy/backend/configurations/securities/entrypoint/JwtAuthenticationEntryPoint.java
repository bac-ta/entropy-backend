package com.entropy.backend.configurations.securities.entrypoint;

import com.entropy.backend.common.constants.ApiMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class response when authentication with JWT is invalid
 *
 * @author bac-ta
 * @see JwtAuthenticationEntryPoint
 * @since 2021-05-31
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException {
        logger.error(ApiMessage.ENDTRY_POINT_UNAUTHORIZED, ApiMessage.ACCOUNT_INVALID);
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, ApiMessage.ACCOUNT_INVALID);
    }
}
