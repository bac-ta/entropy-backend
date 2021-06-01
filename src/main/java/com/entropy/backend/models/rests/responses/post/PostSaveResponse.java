package com.entropy.backend.models.rests.responses.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostSaveResponse {
    private Integer id;
    private String message;
}
