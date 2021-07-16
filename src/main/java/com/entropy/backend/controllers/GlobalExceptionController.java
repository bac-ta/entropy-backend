package com.entropy.backend.controllers;

import com.entropy.backend.models.exceptions.AccountAlreadyExistException;
import com.entropy.backend.models.exceptions.AccountRoleInvalidException;
import com.entropy.backend.models.exceptions.EnumNotFoundException;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import com.entropy.backend.models.rests.responses.errors.GlobalExceptionResponse;
import com.entropy.backend.models.rests.responses.user.UserRegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.Collections;
import java.util.List;

/**
 * Class AOP for catch and return if request API has exception
 *
 * @author bac-ta
 * @see GlobalExceptionController
 * @since 2021-05-31
 */
@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

    /**
     * Provides handling for exceptions throughout this service.
     *
     * @param ex      The target exception
     * @param request The current request
     */
    @ExceptionHandler({
            ResourceNotFoundExceptionHandler.class,
            AccountAlreadyExistException.class,
            AccountRoleInvalidException.class,
            EnumNotFoundException.class
    })
    @Nullable
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        LOGGER.error("Handling " + ex.getClass().getSimpleName() + " due to " + ex.getMessage());

        if (ex instanceof ResourceNotFoundExceptionHandler) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            ResourceNotFoundExceptionHandler exception = (ResourceNotFoundExceptionHandler) ex;

            return handleUserNotFoundException(exception, headers, status, request);
        } else if (
                        ex instanceof AccountAlreadyExistException ||
                        ex instanceof AccountRoleInvalidException ||
                        ex instanceof EnumNotFoundException
        ) {
            return new ResponseEntity<>(
                    new UserRegistrationResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                    HttpStatus.BAD_REQUEST);

        } else {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Unknown exception type: " + ex.getClass().getName());
            }

            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    /**
     * Customize the response for ResourceNotFoundExceptionHandler.
     *
     * @param ex      The exception
     * @param headers The headers to be written to the response
     * @param status  The selected response status
     * @return a {@code ResponseEntity} instance
     */
    protected ResponseEntity<Object> handleUserNotFoundException(ResourceNotFoundExceptionHandler ex,
                                                                 HttpHeaders headers, HttpStatus status,
                                                                 WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new GlobalExceptionResponse(errors), headers, status, request);
    }

    /**
     * A single place to customize the response body of all Exception types.
     *
     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
     * request attribute and creates a {@link ResponseEntity} from the given
     * body, headers, and status.
     *
     * @param ex      The exception
     * @param body    The body for the response
     * @param headers The headers for the response
     * @param status  The response status
     * @param request The current request
     */
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable GlobalExceptionResponse body,
                                                             HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
