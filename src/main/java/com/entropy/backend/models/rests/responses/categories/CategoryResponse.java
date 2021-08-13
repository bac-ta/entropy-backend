package com.entropy.backend.models.rests.responses.categories;

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
