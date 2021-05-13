package com.entropy.backend.model.rest.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String message;

    public CategoryResponse(String message) {
        this.message = message;
    }
}
