package com.entropy.backend.model.rest.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostSaveResp {
    private Integer id;
    private String message;
}
