package com.entropy.backend.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class UserPrincipalDto {
    private String username;
    private String email;
    private Byte type;
}
