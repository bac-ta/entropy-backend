package com.entropy.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFetchByIdDto extends PostDto {
    private String content;
    @JsonProperty("image_title")
    private String imageTitle;
    @JsonProperty("category_info_list")
    private List<CategoryDto> categoryDtoInfoList;

}
