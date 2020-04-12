package com.entropy.backend.model.rest.request.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class CategoryCreateReq {
    @JsonProperty("category_type")
    @NotNull
    private String categoryType;
}
