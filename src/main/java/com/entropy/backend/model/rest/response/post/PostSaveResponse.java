package com.entropy.backend.model.rest.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostSaveResponse {
    private Integer id;
    private String message;
}
