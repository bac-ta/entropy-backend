package com.entropy.backend.model.rest.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResp {
    private Integer id;
    private String message;

    public CategoryResp(String message) {
        this.message = message;
    }
}
