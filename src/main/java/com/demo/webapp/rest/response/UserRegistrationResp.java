package com.demo.webapp.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResp {
    private Long id;
    private String message;
    private HttpStatus status;
}
