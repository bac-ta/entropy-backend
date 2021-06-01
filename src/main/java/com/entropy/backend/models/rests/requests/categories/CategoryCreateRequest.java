package com.entropy.backend.models.rests.requests.categories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class CategoryCreateRequest {
    @JsonProperty("category_type")
    @NotNull
    private String categoryType;
}
