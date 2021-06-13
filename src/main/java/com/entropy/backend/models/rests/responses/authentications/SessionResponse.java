package com.entropy.backend.models.rests.responses.authentications;

import com.entropy.backend.models.dtos.SessionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {
    public List<SessionDTO> sessions;
}
