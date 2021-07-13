package com.entropy.backend.models.rests.responses.authentications;

import com.entropy.backend.models.dtos.SessionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor

public class SessionResponse {
    public List<SessionDto> sessions;
}
