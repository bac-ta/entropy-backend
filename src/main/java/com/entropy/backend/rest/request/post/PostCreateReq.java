package com.entropy.backend.rest.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostCreateReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    @JsonProperty("category_type")
    private Integer categoryType;
    @NotBlank
    private String author;
    @NotNull
    @JsonProperty("publish_type")
    private Integer publishType;
}
