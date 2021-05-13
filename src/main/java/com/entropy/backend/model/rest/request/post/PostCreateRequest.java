package com.entropy.backend.model.rest.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
public class PostCreateRequest {
    @NotBlank
    @JsonProperty(required = true)
    private String title;
    @NotBlank
    @JsonProperty(value = "image_title", required = true)
    private String imageTitle;
    @NotBlank
    @JsonProperty(required = true)
    private String content;
    @JsonProperty("category_ids")
    private List<Integer> categoryIds;
    @NotNull
    @JsonProperty(value = "publish_type", required = true)
    private Integer publishType;
}
