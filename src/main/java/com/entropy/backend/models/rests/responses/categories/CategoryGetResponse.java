package com.entropy.backend.models.rests.responses.categories;

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
