package com.entropy.backend.model.rest.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryGetResponse {
    private Integer id;
    @JsonProperty("category_type")
    private String categoryType;
}
