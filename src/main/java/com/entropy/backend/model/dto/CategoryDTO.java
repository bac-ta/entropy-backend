package com.entropy.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    @JsonProperty("category_type")
    private String categoryType;
    private String updated;
    @JsonProperty("status_type")
    private String statusType;
}
