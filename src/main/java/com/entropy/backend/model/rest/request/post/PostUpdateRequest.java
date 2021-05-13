package com.entropy.backend.model.rest.request.post;

import com.entropy.backend.model.enumeration.PublishType;
import com.entropy.backend.model.enumeration.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@ToString
public class PostUpdateRequest {
    @NotBlank
    @JsonProperty(required = true)
    private String title;
    @NotBlank
    @JsonProperty(value = "image_title", required = true)
    private String imageTitle;
    @NotBlank
    @JsonProperty(required = true)
    private String content;
    @JsonProperty("category_use_ids")
    private List<Integer> categoryUseIds;
    @JsonProperty(value = "publish_type")
    private Integer publishType = PublishType.PUBLISH.getValue();
    @JsonProperty(value = "status_type")
    private Integer statusType = StatusType.ON.getValue();
}

