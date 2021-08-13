package com.entropy.backend.models.rests.requests.authentications;

import com.entropy.backend.models.anonations.FieldRequired;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoRequest {
    @FieldRequired(fieldName = "username")
    private String username;
    @FieldRequired(fieldName = "password")
    private String password;
}
