package com.entropy.backend.model.rest.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
public class PostCreateReq {
    @NotBlank
    private String title;
    @NotBlank
    @JsonProperty("image_title")
    private String imageTitle;
    @NotBlank
    private String content;
    @NotNull
    @JsonProperty("category_ids")
    private List<Integer> categoryIds;
    @NotNull
    @JsonProperty("publish_type")
    private Integer publishType;
}
