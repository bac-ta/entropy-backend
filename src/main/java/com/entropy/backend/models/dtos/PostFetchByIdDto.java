package com.entropy.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PostFetchByIdDto extends PostDto {
    private String content;
    @JsonProperty("image_title")
    private String imageTitle;
    @JsonProperty("category_info_list")
    private List<CategoryDto> categoryDtoInfoList;

}
